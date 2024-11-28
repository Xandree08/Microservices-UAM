package com.projecta3.ticketservices.consumers;

import com.projecta3.ticketservices.dtos.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service" , url = "http://localhost:8080")
public interface UserFeignService  {

    @GetMapping("/users/{id}")
    UserResponse getUserById(@PathVariable("id") Long id);


}
