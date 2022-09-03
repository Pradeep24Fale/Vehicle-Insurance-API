package com.vehicle.insuarance.VehicleInsurance.Service;

import com.vehicle.insuarance.VehicleInsurance.Entity.InsuranceProduct;
import com.vehicle.insuarance.VehicleInsurance.Exception.CustomErrorException;
import com.vehicle.insuarance.VehicleInsurance.Repository.InsuranceProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceProductService {

    @Autowired
    private InsuranceProductRepository insuranceProductRepository;
    public List<InsuranceProduct> getAllInsuranceProductsTypes() {

        return insuranceProductRepository.findAll();
    }

    public InsuranceProduct findById(Integer id)
    {
        return insuranceProductRepository.findById(id).orElseThrow(()->new CustomErrorException(HttpStatus.NOT_FOUND,"No Data available"));
    }
}
