package com.projecta3.appointmentservice.dtos;

import java.time.LocalDateTime;

public class AppointmentResponse {

    private Long id;
    private Long ticketId;
    private Long userId;
    private LocalDateTime appointmentTime;
    private String status;

    public AppointmentResponse(){};

    public AppointmentResponse(Long ticketId, Long userId, LocalDateTime appointmentTime) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.appointmentTime = appointmentTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
