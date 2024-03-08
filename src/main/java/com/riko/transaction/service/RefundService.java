package com.riko.transaction.service;

import com.riko.transaction.model.Refund;
import com.riko.transaction.model.dto.RefundMinDTO;
import com.riko.transaction.model.enums.TransactionalStatus;

public interface RefundService {

    Refund getRefund(Long id);
    Refund createRefund(RefundMinDTO refundMinDTO);
    Refund statusChangeRefund(Long id, TransactionalStatus status);
    Refund getRefundByTicketId(Long ticketId);
}
