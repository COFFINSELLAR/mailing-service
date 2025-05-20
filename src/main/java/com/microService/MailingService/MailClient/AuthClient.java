package com.microService.MailingService.MailClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthClient {
    @GetMapping("/api/auth/validate")
    ResponseEntity<String> validateToken(@RequestHeader("Authorization") String token);
}

