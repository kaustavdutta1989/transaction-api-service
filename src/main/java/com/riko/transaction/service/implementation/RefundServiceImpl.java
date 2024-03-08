package com.riko.transaction.service.implementation;

import com.riko.transaction.model.Refund;
import com.riko.transaction.model.dto.RefundMinDTO;
import com.riko.transaction.model.enums.TransactionalStatus;
import com.riko.transaction.repo.RefundRepository;
import com.riko.transaction.service.PaymentService;
import com.riko.transaction.service.RefundService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final RefundRepository refundRepository;
    private final PaymentService paymentService;

    @Override
    public Refund getRefund(Long id) {
        return refundRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("refund not found with id: " + id));
    }

    @Override
    public Refund createRefund(RefundMinDTO refundMinDTO) {
        return refundRepository.save(Refund.builder()
                .payment(paymentService.getPayment(refundMinDTO.getPaymentId()))
                .amount(refundMinDTO.getAmount())
                .ticketId(refundMinDTO.getTicketId())
                .build());
    }

    @Override
    public Refund statusChangeRefund(Long id, TransactionalStatus status) {
        Refund refund = getRefund(id);
        refund.setStatus(status);
        return refundRepository.save(refund);
    }

    @Override
    public Refund getRefundByTicketId(Long ticketId) {
        return refundRepository.findByTicketId(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("refund not found for ticketId: " + ticketId));
    }
}
