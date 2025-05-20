package com.microService.MailingService.service;

import com.microService.MailingService.MailClient.AuthClient;
import com.microService.MailingService.MailClient.UserClient;
import com.microService.MailingService.dto.UserDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private AuthClient authClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserDTO userDTO;

    public ResponseEntity<?> sendMail(String token, String username) {
        try {
            ResponseEntity<String> authResponse = authClient.validateToken(token);
            if (authResponse.getStatusCode().is2xxSuccessful()) {
                UserDTO userDTO = userClient.getUserEmailByUsername(username);
                sendEmails(userDTO.getEmail(), "Account Info", "Hello " + userDTO.getUserName() + ", your order will be delivered by");
                return ResponseEntity.ok("Email sent successfully");
            } else {
                return ResponseEntity.status(authResponse.getStatusCode()).body("Invalid token");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to send mail: " + e.getMessage());
        }
    }


    @Async
    public void sendEmails(String to, String subject, String body) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        mailSender.send(message);
    }
}
