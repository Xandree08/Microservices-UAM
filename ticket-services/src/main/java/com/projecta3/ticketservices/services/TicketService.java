package com.projecta3.ticketservices.services;

import com.projecta3.ticketservices.consumers.UserFeignService;
import com.projecta3.ticketservices.dtos.UserResponse;
import com.projecta3.ticketservices.entities.Ticket;
import com.projecta3.ticketservices.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final UserFeignService userFeignService;
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository, UserFeignService userFeignService) {
        this.ticketRepository = ticketRepository;
        this.userFeignService = userFeignService;
    }

    public Ticket createTicket(Ticket ticket) {

        UserResponse user = userFeignService.getUserById(ticket.getUserId());
        ticket.setStudent(user.getName());
        ticket.setCreatedAt(LocalDateTime.now());

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setDescription(updatedTicket.getDescription());
            ticket.setStatus(updatedTicket.getStatus());
            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
