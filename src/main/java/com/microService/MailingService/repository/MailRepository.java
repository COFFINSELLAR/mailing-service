package com.microService.MailingService.repository;

import com.microService.MailingService.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailEntity,Long> {
}
