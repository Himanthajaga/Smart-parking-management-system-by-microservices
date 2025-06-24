package lk.ijse.parkingspaceservice.service;

import lk.ijse.parkingspaceservice.entity.ParkingSpot;
import lk.ijse.parkingspaceservice.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    @Autowired
    public ParkingRepository repo;

    public List<ParkingSpot> findAvailableSpots() {
        return repo.findByAvailableTrue();
    }

    public ResponseEntity<String> reserveSpot(Long id) {
        return repo.findById(id)
                .map(spot -> {
                    if (!spot.isAvailable()) {
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("Parking spot is already reserved.");
                    }
                    spot.setAvailable(false);
                    repo.save(spot);
                    return ResponseEntity.ok("Reserved");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found."));
    }

    public ResponseEntity<String> addParkingSpot(ParkingSpot spot) {
        repo.save(spot);
        return ResponseEntity.ok("Parking spot added successfully.");
    }

    public ResponseEntity<String> updateParkingSpot(Long id, ParkingSpot updatedSpot) {
        return repo.findById(id)
                .map(spot -> {
                    spot.setLocation(updatedSpot.getLocation());
                    spot.setAvailable(updatedSpot.isAvailable());
                    repo.save(spot);
                    return ResponseEntity.ok("Parking spot updated successfully.");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found."));
    }

    public ResponseEntity<String> deleteParkingSpot(Long id) {
        return repo.findById(id)
                .map(spot -> {
                    repo.delete(spot);
                    return ResponseEntity.ok("Parking spot deleted successfully.");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found."));
    }
}
