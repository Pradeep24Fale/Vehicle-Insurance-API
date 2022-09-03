package com.vehicle.insuarance.VehicleInsurance.Service;

import com.vehicle.insuarance.VehicleInsurance.Entity.Customer;
import com.vehicle.insuarance.VehicleInsurance.Exception.CustomErrorException;
import com.vehicle.insuarance.VehicleInsurance.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer addCustomer(Customer c)
    {
       return customerRepository.save(c);
    }

    public Customer findCustomerById(Integer customerId)
    {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomErrorException(HttpStatus.NOT_FOUND, "customer not found"));
    }

}