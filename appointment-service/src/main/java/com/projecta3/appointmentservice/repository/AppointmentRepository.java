package com.projecta3.appointmentservice.repository;

import com.projecta3.appointmentservice.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByTicketId(Long ticketId);
}
