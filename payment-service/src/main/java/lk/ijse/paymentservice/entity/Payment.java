package lk.ijse.paymentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    private String cardNumber;
    private double amount;
    private String status;
    private LocalDateTime timestamp;

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Payment(Long id, String cardNumber, double amount, String status, LocalDateTime timestamp) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.status = status;
        this.timestamp = timestamp;
    }
}
