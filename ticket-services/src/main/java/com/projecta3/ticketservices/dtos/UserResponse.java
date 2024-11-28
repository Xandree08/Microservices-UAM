package com.projecta3.ticketservices.dtos;

public class UserResponse {

    private Long id;
    private String name;
    private String ra;
    private String email;
    private String password;

    public UserResponse(){}

    public UserResponse(String name, String ra, String email, String password) {
        this.name = name;
        this.ra = ra;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

