package com.riko.transaction.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String transactionId;

    @Column(nullable = false)
    private Double cost;

    @Column(nullable = false)
    private Double discount;

    @Column(nullable = false)
    private Double amount;

    @CreatedDate
    private LocalDateTime localDateTime;
}
