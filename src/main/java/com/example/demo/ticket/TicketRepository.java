package com.example.demo.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository
        extends JpaRepository<Ticket,Long> {
    @Override
    Optional<Ticket> findById(Long aLong);
};
