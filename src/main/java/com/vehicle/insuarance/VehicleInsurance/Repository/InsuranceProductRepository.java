package com.vehicle.insuarance.VehicleInsurance.Repository;

import com.vehicle.insuarance.VehicleInsurance.Entity.InsuranceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceProductRepository extends JpaRepository<InsuranceProduct,Integer> {
}
