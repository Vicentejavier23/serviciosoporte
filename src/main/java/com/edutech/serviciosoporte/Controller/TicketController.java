package com.edutech.serviciosoporte.Controller;

import com.edutech.serviciosoporte.Model.TicketSoporte;
import com.edutech.serviciosoporte.Service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketService servicio;

    public TicketController(TicketService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<TicketSoporte> listar() {
        return servicio.listar();
    }

    @PutMapping("/{id}/estado")
    public TicketSoporte actualizarEstado(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String estado = request.get("estado");
        return servicio.actualizarEstado(id, estado);
    }

    @PostMapping
    public TicketSoporte crear(@RequestBody Map<String, Object> requestBody) {
        TicketSoporte ticket = new TicketSoporte();
        ticket.setAsunto((String) requestBody.get("asunto"));
        ticket.setDescripcion((String) requestBody.get("descripcion"));

        String estado = (String) requestBody.get("estado");
        return servicio.crear(ticket, estado);
    }
}




