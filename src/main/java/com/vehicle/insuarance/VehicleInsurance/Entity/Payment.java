package com.vehicle.insuarance.VehicleInsurance.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private String accountNumber;
    private String creditCardNumber;
    private Integer cvv;
    private double balance;
}
