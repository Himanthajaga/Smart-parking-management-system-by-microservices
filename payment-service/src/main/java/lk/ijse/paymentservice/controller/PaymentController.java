package lk.ijse.paymentservice.controller;

import lk.ijse.paymentservice.entity.Payment;
import lk.ijse.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @PostMapping("/pay")
    public Payment pay(@RequestBody Payment payment) {
        return service.process(payment);
    }

    @GetMapping("/{id}")
    public Payment get(@PathVariable Long id) {
        return service.repo.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Payment> all() {
        return service.repo.findAll();
    }

    @PutMapping("/update/{id}")
    public Payment update(@PathVariable Long id, @RequestBody Payment updated) {
        return service.update(id, updated);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.repo.deleteById(id);
        return "Payment deleted successfully.";
    }
//    Validate mock card/payment data
    @PostMapping("/validate")
    public String validate(@RequestBody Payment payment) {
        // Mock validation logic
        if (payment.getCardNumber() == null || payment.getCardNumber().isEmpty()) {
            throw new RuntimeException("Invalid card number");
        }
        if (payment.getAmount() <= 0) {
            throw new RuntimeException("Invalid payment amount");
        }
        return "Payment validated successfully";
    }
//    Generate digital receipt
    @PostMapping("/receipt")
    public String generateReceipt(@RequestBody Payment payment) {
        // Mock receipt generation logic
        return "Receipt generated for payment ID: " + payment.getId() + " with amount: " + payment.getAmount();
    }
}
