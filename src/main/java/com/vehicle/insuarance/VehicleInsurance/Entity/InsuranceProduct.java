package com.vehicle.insuarance.VehicleInsurance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class InsuranceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productDetails;
    @JsonIgnore
    @OneToMany (mappedBy = "insuranceProduct",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Policy> policyList;

    public InsuranceProduct() {
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public InsuranceProduct(int productId, String productName, String productDetails) {
        this.productId = productId;
        this.productName = productName;
        this.productDetails = productDetails;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }
}
