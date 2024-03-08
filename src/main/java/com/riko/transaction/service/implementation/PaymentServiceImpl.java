package com.riko.transaction.service.implementation;

import com.riko.transaction.model.Payment;
import com.riko.transaction.model.dto.PaymentMinDTO;
import com.riko.transaction.repo.PaymentRepository;
import com.riko.transaction.service.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment getPayment(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("payment not found for id: " + id));
    }

    @Override
    public Payment createPayment(PaymentMinDTO paymentMinDTO) {
        log.info("creating payment for : {}", paymentMinDTO);
        String transactionId = UUID.randomUUID().toString();
        log.info("creating payment for transactionId: {}", transactionId);
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("creating payment for localDateTime: {}", localDateTime);
        return paymentRepository.save(Payment.builder()
                .transactionId(transactionId)
                .localDateTime(localDateTime)
                .amount(paymentMinDTO.getAmount())
                .cost(paymentMinDTO.getCost())
                .discount(paymentMinDTO.getDiscount())
                .build());
    }
}
