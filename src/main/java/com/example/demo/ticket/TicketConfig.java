package com.example.demo.ticket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TicketConfig {
    @Bean
    CommandLineRunner commandLineRunner(TicketRepository repository){
        return args -> {
            Ticket firstTicket = new Ticket(1L,"Undefined",
                    "Something wrong",
                    LocalDate.of(2021,
                            Month.NOVEMBER,11),
                    'H',
                    'I'
                    );
            Ticket secondTicket = new Ticket(
                    2L,"Undefined",
                    "All is wrong",
                    LocalDate.of(2021,
                            Month.NOVEMBER,
                            12),
                    'H',
                    'I');
            repository.saveAll(List.of(firstTicket,secondTicket));
        };
    };
}
