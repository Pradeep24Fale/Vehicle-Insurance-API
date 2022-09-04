package com.vehicle.insuarance.VehicleInsurance.Controller;
import com.vehicle.insuarance.VehicleInsurance.Entity.InsuranceProduct;
import com.vehicle.insuarance.VehicleInsurance.Entity.SuccessResponseEntity;
import com.vehicle.insuarance.VehicleInsurance.Service.InsuranceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class InsuranceProductController {
    @Autowired
    private InsuranceProductService insuranceProductService;

    @GetMapping("/insurance-products")
    public ResponseEntity<SuccessResponseEntity> getAllInsuranceProductsTypes()
    {
        SuccessResponseEntity successResponseEntity=new SuccessResponseEntity(HttpStatus.OK,insuranceProductService.getAllInsuranceProductsTypes());
        return new ResponseEntity<>(successResponseEntity,HttpStatus.OK);
    }

    @GetMapping("/insurance-products/{productId}")
    public ResponseEntity<SuccessResponseEntity> getPoliciesByProductId(@PathVariable Integer productId)
    {
        InsuranceProduct insuranceProduct=insuranceProductService.findById(productId);
        SuccessResponseEntity successResponseEntity=new SuccessResponseEntity(HttpStatus.OK,insuranceProduct.getPolicyList());

            return new ResponseEntity<>(successResponseEntity,HttpStatus.OK);
    }
}
