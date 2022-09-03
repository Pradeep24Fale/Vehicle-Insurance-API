package com.vehicle.insuarance.VehicleInsurance.Entity;

import lombok.Data;

import java.util.List;

@Data
public class PaymentBody {
    private Integer customerId;
    private String accountNumber;
    private String cardNumber;
    private Integer cvv;
    private List<Integer> policyList;
}
