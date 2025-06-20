package lk.ijse.vehicleservice.controller;

import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @PostMapping("/register")
    public Vehicle register(@RequestBody Vehicle v) {
        return service.register(v);
    }

    @PutMapping("/enter/{id}")
    public Vehicle enter(@PathVariable Long id) {
        return service.simulateEntry(id);
    }

    @PutMapping("/exit/{id}")
    public Vehicle exit(@PathVariable Long id) {
        return service.simulateExit(id);
    }

    @GetMapping("/user/{userId}")
    public List<Vehicle> byUser(@PathVariable String userId) {
        return service.repo.findByUserId(userId);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.repo.deleteById(id);
        return "Vehicle deleted successfully.";
    }
    @PostMapping("/update/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle updated) {
        return service.update(id, updated);
    }
}
