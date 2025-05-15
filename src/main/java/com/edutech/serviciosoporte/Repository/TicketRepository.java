package com.edutech.serviciosoporte.Repository;


import com.edutech.serviciosoporte.Model.TicketSoporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketSoporte, Long> {
}
