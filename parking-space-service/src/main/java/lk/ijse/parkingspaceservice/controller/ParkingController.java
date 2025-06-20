package lk.ijse.parkingspaceservice.controller;

import lk.ijse.parkingspaceservice.entity.ParkingSpot;
import lk.ijse.parkingspaceservice.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parking")
public class ParkingController {
    @Autowired
    private ParkingRepository repo;

    @GetMapping("/available")
    public List<ParkingSpot> available() {
        return repo.findByAvailableTrue();
    }
    @PostMapping("/reserve/{id}")
    public ResponseEntity<String> reserve(@PathVariable Long id) {
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
    @PostMapping("/add")
    public ResponseEntity<String> addParkingSpot(@RequestBody ParkingSpot spot) {
        repo.save(spot);
        return ResponseEntity.ok("Parking spot added successfully.");
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateParkingSpot(@PathVariable Long id, @RequestBody ParkingSpot updatedSpot) {
        return repo.findById(id)
                .map(spot -> {
                    spot.setLocation(updatedSpot.getLocation());
                    spot.setAvailable(updatedSpot.isAvailable());
                    repo.save(spot);
                    return ResponseEntity.ok("Parking spot updated successfully.");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found."));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteParkingSpot(@PathVariable Long id) {
        return repo.findById(id)
                .map(spot -> {
                    repo.delete(spot);
                    return ResponseEntity.ok("Parking spot deleted successfully.");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found."));
    }
}
