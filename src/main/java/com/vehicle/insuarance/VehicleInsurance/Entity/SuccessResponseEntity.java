package com.vehicle.insuarance.VehicleInsurance.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class SuccessResponseEntity {
    private HttpStatus httpStatus;
    private Object data;
}
