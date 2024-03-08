package com.riko.transaction.controller;

import com.riko.transaction.model.Refund;
import com.riko.transaction.model.dto.RefundMinDTO;
import com.riko.transaction.model.enums.TransactionalStatus;
import com.riko.transaction.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/refund")
public class RefundController {

    private final RefundService refundService;

    @GetMapping
    ResponseEntity<Refund> getRefund(@RequestParam Long id) {
        return ResponseEntity.ok(refundService.getRefund(id));
    }

    @PostMapping
    ResponseEntity<Refund> createRefund(@RequestBody RefundMinDTO refundMinDTO) {
        return ResponseEntity.ok(refundService.createRefund(refundMinDTO));
    }

    @PatchMapping
    ResponseEntity<Refund> statusChangeRefund(@RequestParam Long id,
                                              @RequestParam TransactionalStatus status) {
        return ResponseEntity.ok(refundService.statusChangeRefund(id, status));
    }

    @GetMapping("/ticket")
    ResponseEntity<Refund> getRefundByTicketId(@RequestParam Long ticketId) {
        return ResponseEntity.ok(refundService.getRefundByTicketId(ticketId));
    }
}
