package com.projecta3.ticketservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TicketServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketServicesApplication.class, args);
    }

}
