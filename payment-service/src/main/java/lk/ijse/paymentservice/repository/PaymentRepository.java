package lk.ijse.paymentservice.repository;

import lk.ijse.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByUserId(String userId);
    Payment findByVehicleId(String vehicleId);
    Payment findByUserIdAndVehicleId(String userId, String vehicleId);
    Payment findByUserIdAndVehicleIdAndStatus(String userId, String vehicleId, String status);
}
