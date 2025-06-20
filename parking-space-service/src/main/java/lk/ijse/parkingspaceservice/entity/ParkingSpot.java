package lk.ijse.parkingspaceservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ParkingSpot {
    @Id @GeneratedValue
    private Long id;
    private String location;
    private boolean available;

    public ParkingSpot() {
    }

    public ParkingSpot(Long id, String location, boolean available) {
        this.id = id;
        this.location = location;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
