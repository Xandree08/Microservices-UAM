package com.projecta3.appointmentservice.services;

import com.projecta3.appointmentservice.consumers.TicketFeignService;
import com.projecta3.appointmentservice.consumers.UserFeignService;
import com.projecta3.appointmentservice.dtos.AppointmentResponse;
import com.projecta3.appointmentservice.dtos.TicketResponse;
import com.projecta3.appointmentservice.dtos.UserResponse;
import com.projecta3.appointmentservice.entities.Appointment;
import com.projecta3.appointmentservice.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServices {

    private final TicketFeignService ticketFeignService;
    private final UserFeignService userFeignService;
    private final AppointmentRepository appointmentRepository;

    public AppointmentServices(AppointmentRepository appointmentRepository,TicketFeignService ticketFeignService, UserFeignService userFeignService ) {
        this.appointmentRepository = appointmentRepository;
        this.ticketFeignService = ticketFeignService;
        this.userFeignService = userFeignService;
    }

    public Appointment createAppointment(AppointmentResponse response) {
        userFeignService.getUserById(response.getUserId());
        ticketFeignService.getTicketById(response.getTicketId());

        UserResponse userResponse = userFeignService.getUserById(response.getUserId());
        TicketResponse ticketResponse = ticketFeignService.getTicketById(response.getTicketId());

        Appointment appointment = new Appointment();
        appointment.setTicketDescription(ticketResponse.getDescription());
        appointment.setStudent(userResponse.getName());
        appointment.setAppointmentTime(response.getAppointmentTime());
        appointment.setUserId(response.getUserId());
        appointment.setTicketId(response.getTicketId());
        appointment.setStatus("SCHEDULED");

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
