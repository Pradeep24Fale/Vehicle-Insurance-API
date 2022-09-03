package com.vehicle.insuarance.VehicleInsurance.Repository;

import com.vehicle.insuarance.VehicleInsurance.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}