package com.vehicle.insuarance.VehicleInsurance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Policy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer policyId;
    private String policyName;
    private String policyDetails;
    private Double premium;
    @JsonIgnore
    @ManyToOne
    private InsuranceProduct insuranceProduct;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "policy_customer",
            joinColumns = { @JoinColumn(name = "policy_id") },
            inverseJoinColumns = { @JoinColumn(name = "customer_id") })
    @JsonIgnore
    private List<Customer> customers;
    /*@JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "customerId")
    private Customer customer;*/






}
