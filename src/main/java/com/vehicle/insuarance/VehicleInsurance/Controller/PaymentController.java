package com.vehicle.insuarance.VehicleInsurance.Controller;
import com.vehicle.insuarance.VehicleInsurance.Entity.PaymentBody;
import com.vehicle.insuarance.VehicleInsurance.Entity.SuccessResponseEntity;
import com.vehicle.insuarance.VehicleInsurance.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping ("/payment")
    public ResponseEntity<SuccessResponseEntity> makePayment(@RequestBody PaymentBody paymentBody) {
            String status = paymentService.makePayment(paymentBody);
            return new ResponseEntity<>(new SuccessResponseEntity(HttpStatus.OK, status), HttpStatus.OK);
    }
}
