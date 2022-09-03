package com.vehicle.insuarance.VehicleInsurance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    private String customerName;
    private String birthDate;
    private String customerEmail;
    private String phoneNumber;
    @Value("incomplete")
    private String paymentStatus;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
    mappedBy = "customers")
    @JsonIgnore
    private List<Policy> policies;

    public Customer(Integer customerId, String customerName, String birthDate, String customerEmail, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.birthDate = birthDate;
        this.customerEmail = customerEmail;
        this.phoneNumber = phoneNumber;
    }
}
