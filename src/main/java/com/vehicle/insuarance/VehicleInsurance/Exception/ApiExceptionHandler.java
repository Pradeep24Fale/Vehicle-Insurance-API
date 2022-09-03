package com.vehicle.insuarance.VehicleInsurance.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomErrorException.class)
    public ResponseEntity<Object> handleCommonException(CustomErrorException ex, WebRequest request) {
        return new ResponseEntity<Object>(new ApiError(ex.getMessage(), ex.getStatus(), LocalDateTime.now()), ex.getStatus());
    }
}
