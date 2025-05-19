package com.edutech.serviciosoporte.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asunto;
    private String descripcion;
    public enum EstadoTicket {
        ABIERTO,
        EN_PROGRESO,
        CERRADO
    }
    @Enumerated(EnumType.STRING)
    private EstadoTicket estado;
    private LocalDate fechaCreacion;
}
