package com.microService.MailingService.MailClient;


import com.microService.MailingService.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    @GetMapping("/user/{username}")
    UserDTO getUserEmailByUsername(@PathVariable String username);
}
