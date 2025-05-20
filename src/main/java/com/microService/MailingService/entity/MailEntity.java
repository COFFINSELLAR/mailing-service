package com.microService.MailingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mails_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String to;
    private String subject;
    private String body;


}
