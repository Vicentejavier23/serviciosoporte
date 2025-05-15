package com.edutech.serviciosoporte.Controller;


import com.edutech.serviciosoporte.Model.TicketSoporte;
import com.edutech.serviciosoporte.Service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService servicio;

    public TicketController(TicketService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<TicketSoporte> listar() {
        return servicio.listar();
    }

    @PostMapping
    public TicketSoporte crear(@RequestBody TicketSoporte ticket) {
        return servicio.crear(ticket);
    }

    @PutMapping("/{id}/estado")
    public TicketSoporte actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
        return servicio.actualizarEstado(id, estado);
    }
}
