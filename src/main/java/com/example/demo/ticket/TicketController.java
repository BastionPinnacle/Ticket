package com.example.demo.ticket;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ticket")
@Tag(name = "Ticket")
public class TicketController {
    private final TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping
    @Operation(summary = "Getting all the cases ",responses = @ApiResponse(description = "Getting all the cases success",
    responseCode = "200",content = @Content(mediaType = "/application/json",schema = @Schema(implementation = Ticket.class))))
    public List<Ticket> getTicket(){
        return ticketService.getTickets();
    }
    @PostMapping
    @Operation(summary = "Adding new case ")
    public void registerNewTicket(@RequestBody Ticket ticket){
        ticketService.addNewTicket(ticket);
    }
    @DeleteMapping(path = "{ticketId}")
    @Operation(summary = "Deleting specific case ")
    public void deleteTicket(@PathVariable("ticketId") Long id){
        ticketService.deleteTicket(id);
    }
    @PutMapping(path = "{ticketId}")
    @Operation(summary = "Updating specific case ")
    public void updateTicket(
        @PathVariable("ticketId") Long ticketId,
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String description,
        @RequestParam(required = false) char severity,
        @RequestParam(required = false) char status
    ){
        ticketService.updateTicket(ticketId,title,description,severity,status);
    }
}
