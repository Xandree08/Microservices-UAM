package com.projecta3.appointmentservice.consumers;

import com.projecta3.appointmentservice.dtos.TicketResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ticket-service" , url = "http://localhost:8081")
public interface TicketFeignService {

    @GetMapping("/tickets/{id}")
    TicketResponse getTicketById(@PathVariable("id") Long id);

}
