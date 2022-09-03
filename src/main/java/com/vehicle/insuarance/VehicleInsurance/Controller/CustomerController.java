package com.vehicle.insuarance.VehicleInsurance.Controller;

import com.vehicle.insuarance.VehicleInsurance.Entity.Customer;
import com.vehicle.insuarance.VehicleInsurance.Entity.SuccessResponseEntity;
import com.vehicle.insuarance.VehicleInsurance.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity<SuccessResponseEntity> addCustomer(@RequestBody Customer customer)
    {
        SuccessResponseEntity successResponseEntity = new SuccessResponseEntity(HttpStatus.OK, customerService.addCustomer(customer));
       return new ResponseEntity<>( successResponseEntity, HttpStatus.OK);
    }
}
