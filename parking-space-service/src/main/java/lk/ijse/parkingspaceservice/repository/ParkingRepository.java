package lk.ijse.parkingspaceservice.repository;

import lk.ijse.parkingspaceservice.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingRepository extends JpaRepository<ParkingSpot, Long> {
    List<ParkingSpot> findByAvailableTrue();

    List<ParkingSpot> findByLocation(String location);

    List<ParkingSpot> findByAvailable(boolean available);
    List<ParkingSpot> findByLocationAndAvailable(String location, boolean available);
}
