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

    public TicketSoporte actualizarEstado(Long id, String nuevoEstado) {
        TicketSoporte ticket = repo.findById(id).orElseThrow(
                () -> new RuntimeException("Ticket no encontrado con ID: " + id));
        ticket.setEstado(validarEstado(nuevoEstado));
        return repo.save(ticket);
    }

    public TicketSoporte crear(TicketSoporte ticket, String estado) {
        ticket.setFechaCreacion(LocalDate.now());
        ticket.setEstado(validarEstado(estado));
        return repo.save(ticket);
    }

    public TicketSoporte.EstadoTicket validarEstado(String estado) {
        String estadoNormalizado = estado.trim().toUpperCase()
                .replace(" ", "_")
                .replace("Í", "I");

        return switch (estadoNormalizado) {
            case "CERRADO", "FINALIZADO" -> TicketSoporte.EstadoTicket.CERRADO;
            case "EN_REVISION", "EN_PROGRESO", "REVISION" -> TicketSoporte.EstadoTicket.EN_PROGRESO;
            default -> TicketSoporte.EstadoTicket.ABIERTO;
        };
    }
}



