package com.projecta3.appointmentservice.dtos;

import java.time.LocalDateTime;

public class TicketResponse {

    private Long id;
    private Long tiketId;
    private String description;
    private LocalDateTime createdAt;
    private String status;

    public TicketResponse(){};

    public TicketResponse(Long id, String description, Long tiketId, String status, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.tiketId = tiketId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTiketId() {
        return tiketId;
    }

    public void setTiketId(Long tiketId) {
        this.tiketId = tiketId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
