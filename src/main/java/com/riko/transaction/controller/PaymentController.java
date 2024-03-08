package com.riko.transaction.controller;

import com.riko.transaction.model.Payment;
import com.riko.transaction.model.Refund;
import com.riko.transaction.model.dto.PaymentMinDTO;
import com.riko.transaction.model.dto.RefundMinDTO;
import com.riko.transaction.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    ResponseEntity<Payment> createPayment(@RequestBody PaymentMinDTO paymentMinDTO) {
        return ResponseEntity.ok(paymentService.createPayment(paymentMinDTO));
    }

    @GetMapping
    ResponseEntity<Payment> getPayment(@RequestParam Long id) {
        return ResponseEntity.ok(paymentService.getPayment(id));
    }
}
