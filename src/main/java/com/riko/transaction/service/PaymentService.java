package com.riko.transaction.service;

import com.riko.transaction.model.Payment;
import com.riko.transaction.model.dto.PaymentMinDTO;

public interface PaymentService {
    Payment getPayment(Long id);
    Payment createPayment(PaymentMinDTO paymentMinDTO);
}
