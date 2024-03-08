package com.riko.transaction.model.dto;

import com.riko.transaction.model.enums.TransactionalStatus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefundMinDTO {
    private Long paymentId;
    private Double amount;
    private TransactionalStatus status;
    private Long ticketId;
}
