package com.edutech.serviciosoporte.Service;

import com.edutech.serviciosoporte.Model.TicketSoporte;
import com.edutech.serviciosoporte.Repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository repo) {
        this.repo = repo;
    }

    public List<TicketSoporte> listar() {
        return repo.findAll();
    }

    public TicketSoporte crear(TicketSoporte ticket) {
        ticket.setFechaCreacion(LocalDate.now());
        ticket.setEstado("ABIERTO");
        return repo.save(ticket);
    }

    public TicketSoporte actualizarEstado(Long id, String nuevoEstado) {
        TicketSoporte ticket = repo.findById(id).orElseThrow();
        ticket.setEstado(nuevoEstado);
        return repo.save(ticket);
    }
}
