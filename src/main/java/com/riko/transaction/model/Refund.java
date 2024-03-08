package com.riko.transaction.model;

import com.riko.transaction.model.enums.TransactionalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Refund {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(nullable = false, columnDefinition = "payment")
    @ManyToOne
    private Payment payment;

    @Column(nullable = false)
    private Long ticketId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private TransactionalStatus status;
}
