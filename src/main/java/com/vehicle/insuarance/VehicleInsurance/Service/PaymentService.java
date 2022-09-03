package com.vehicle.insuarance.VehicleInsurance.Service;

import com.vehicle.insuarance.VehicleInsurance.Entity.Customer;
import com.vehicle.insuarance.VehicleInsurance.Entity.Payment;
import com.vehicle.insuarance.VehicleInsurance.Entity.PaymentBody;
import com.vehicle.insuarance.VehicleInsurance.Entity.Policy;
import com.vehicle.insuarance.VehicleInsurance.Exception.CustomErrorException;
import com.vehicle.insuarance.VehicleInsurance.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private CustomerService customerService;

    @Transactional
    public String makePayment(PaymentBody paymentBody)
    {
        if(ObjectUtils.isEmpty(paymentBody)) {
            throw new CustomErrorException(HttpStatus.EXPECTATION_FAILED, "Please add body");
        } else {
            Payment payment = paymentRepository.findById(paymentBody.getAccountNumber()).orElseThrow(() -> new CustomErrorException(HttpStatus.NOT_FOUND, "Account Not found"));
                if(payment.getCreditCardNumber().equalsIgnoreCase(paymentBody.getCardNumber()) && payment.getCvv().equals(paymentBody.getCvv())) {
                    Double totalPremium = calculateTotalPremium(paymentBody.getPolicyList());
                    if (payment.getBalance() >= totalPremium) {
                        payment.setBalance(payment.getBalance() - totalPremium);
                        updateCustomer(paymentBody.getCustomerId(), paymentBody.getPolicyList());
                        paymentRepository.save(payment);
                        return "payment successful";
                    } else {
                        throw new CustomErrorException(HttpStatus.EXPECTATION_FAILED, "Insufficient balance");
                    }
            } else {
                throw new CustomErrorException(HttpStatus.NOT_FOUND, "Account Not found");
            }
        }

    }

    private Double calculateTotalPremium(List<Integer> policyIdList) {
        AtomicReference<Double> totalPremium= new AtomicReference<>(0.0);
        List<Policy> policyList = getPoliciesByPolicyId(policyIdList);
        policyList.stream().forEach(p -> {
            Double balance = p.getPremium();
            totalPremium.set(totalPremium.get() + balance);
        });
        return totalPremium.get();
    }

    private Customer updateCustomer(Integer customerId, List<Integer> policyIdList)
    {
      Customer customer=  customerService.findCustomerById(customerId);
          List<Policy> policyList = getPoliciesByPolicyId(policyIdList);
          if(!ObjectUtils.isEmpty(policyList)) {
              customer.setPaymentStatus("paid");
              customer.setPolicies(policyList);
              return customerService.addCustomer(customer);
          } else {
              throw new CustomErrorException(HttpStatus.NOT_FOUND, "There are no policies selected by customer");
          }

    }

    private List<Policy> getPoliciesByPolicyId(List<Integer> policyIdList) {
        List<Policy> policyList = new ArrayList<>();
        policyIdList.stream().forEach(p -> {
            Policy policy = policyService.findPolicyById(p);
                policyList.add(policy);
        });
        return policyList;
    }
}
