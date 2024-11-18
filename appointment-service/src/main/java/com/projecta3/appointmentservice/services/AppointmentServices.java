package com.projecta3.appointmentservice.services;

import com.projecta3.appointmentservice.entities.Appointment;
import com.projecta3.appointmentservice.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServices {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServices(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getAppointmentsByTicketId(Long ticketId) {
        return appointmentRepository.findByTicketId(ticketId);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
            appointment.setStatus(updatedAppointment.getStatus());
            return appointmentRepository.save(appointment);
        }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
