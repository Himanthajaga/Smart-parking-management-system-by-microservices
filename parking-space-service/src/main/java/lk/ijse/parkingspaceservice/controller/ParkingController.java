package lk.ijse.parkingspaceservice.controller;

import lk.ijse.parkingspaceservice.entity.ParkingSpot;
import lk.ijse.parkingspaceservice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("/available")
    public List<ParkingSpot> available() {
        return parkingService.findAvailableSpots();
    }

    @PostMapping("/reserve/{id}")
    public ResponseEntity<String> reserve(@PathVariable Long id) {
        return parkingService.reserveSpot(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addParkingSpot(@RequestBody ParkingSpot spot) {
        return parkingService.addParkingSpot(spot);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateParkingSpot(@PathVariable Long id, @RequestBody ParkingSpot updatedSpot) {
        return parkingService.updateParkingSpot(id, updatedSpot);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteParkingSpot(@PathVariable Long id) {
        return parkingService.deleteParkingSpot(id);
    }
}