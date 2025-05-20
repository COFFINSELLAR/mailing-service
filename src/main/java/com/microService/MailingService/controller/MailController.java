package com.microService.MailingService.controller;

import com.microService.MailingService.MailClient.AuthClient;
import com.microService.MailingService.MailClient.UserClient;
import com.microService.MailingService.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/sendMail/{username}")
    public ResponseEntity<?> sendMail( @RequestHeader("Authorization") String token,
                                       @PathVariable("username") String username){
        return mailService.sendMail(token,username);
    }


}
