package com.riko.transaction.repo;

import com.riko.transaction.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefundRepository extends JpaRepository<Refund, Long> {
    Optional<Refund> findByTicketId(Long ticketId);
}
