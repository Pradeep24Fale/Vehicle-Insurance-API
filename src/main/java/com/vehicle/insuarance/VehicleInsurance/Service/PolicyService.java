package com.vehicle.insuarance.VehicleInsurance.Service;

import com.vehicle.insuarance.VehicleInsurance.Entity.Policy;
import com.vehicle.insuarance.VehicleInsurance.Exception.CustomErrorException;
import com.vehicle.insuarance.VehicleInsurance.Repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    public Policy findPolicyById(Integer id)
    {
      return  policyRepository.findById(id).orElseThrow(()-> new CustomErrorException(HttpStatus.NOT_FOUND, "Policy not fond" ));
    }
}
