package com.example.demo.ticket;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.io.ObjectStreamClass;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

    public void addNewTicket(Ticket ticket){
        Optional<Ticket> ticketById = ticketRepository.findById(ticket.getId());
        if(ticketById.isPresent()) {
            throw new IllegalStateException("ID exists already");
        }
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Long ticketId){
        boolean exists = ticketRepository.existsById(ticketId);
        if(!(exists)){
            throw new IllegalStateException(
                    "Ticket wit that id: " + ticketId + " does not exists"
            );
        }
        ticketRepository.deleteById(ticketId);
    }

    @Transactional
    public void updateTicket(
            Long ticketId,
            String title,
             String description,
            char severity,
            char status
    ){
        boolean exists = ticketRepository.existsById(ticketId);
        if(!exists) throw new IllegalStateException(
                "ticket of id: " + ticketId +" does not exists"
        );
        Ticket ticket = ticketRepository.getById(ticketId);
        if(title != null && title.length()>0){
            ticket.setTitle(title);
        }
        if(description != null && description.length()>0){
            ticket.setDescription(title);
        }
        ticket.setSeverity(severity);
        ticket.setStatus(status);
    }

}
