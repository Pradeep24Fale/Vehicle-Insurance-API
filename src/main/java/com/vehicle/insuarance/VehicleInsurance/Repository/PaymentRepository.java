package com.vehicle.insuarance.VehicleInsurance.Repository;

import com.vehicle.insuarance.VehicleInsurance.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String> {
}
