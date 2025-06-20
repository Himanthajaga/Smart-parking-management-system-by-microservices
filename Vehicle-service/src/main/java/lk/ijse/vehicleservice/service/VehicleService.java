package lk.ijse.vehicleservice.service;

import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    public VehicleRepository repo;

    public Vehicle register(Vehicle v) {
        return repo.save(v);
    }

    public Vehicle simulateEntry(Long id) {
        Vehicle v = repo.findById(id).orElseThrow();
        v.setInside(true);
        return repo.save(v);
    }

    public Vehicle simulateExit(Long id) {
        Vehicle v = repo.findById(id).orElseThrow();
        v.setInside(false);
        return repo.save(v);
    }

    public Vehicle update(Long id, Vehicle updated) {
        return repo.findById(id)
                .map(vehicle -> {
                    vehicle.setUserId(updated.getUserId());
                    vehicle.setType(updated.getType());
                    vehicle.setInside(updated.isInside());
                    return repo.save(vehicle);
                })
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }
}
