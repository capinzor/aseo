package com.serviaseo.service;

import com.serviaseo.model.EmailLog;
import com.serviaseo.repository.EmailLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MockEmailService {

    private static final Logger logger = LoggerFactory.getLogger(MockEmailService.class);
    private final EmailLogRepository emailLogRepository;

    public MockEmailService(EmailLogRepository emailLogRepository) {
        this.emailLogRepository = emailLogRepository;
    }

    public void sendInvoiceEmail(String to, String subject, String body, byte[] attachment) {
        logger.info("Simulando envío de correo electrónico...");
        logger.info("Destinatario: {}", to);
        logger.info("Asunto: {}", subject);
        logger.info("Cuerpo: {}", body);
        logger.info("Adjunto (tamaño): {} bytes", attachment != null ? attachment.length : 0);

        EmailLog emailLog = new EmailLog();
        emailLog.setRecipient(to);
        emailLog.setSubject(subject);
        emailLog.setBody(body);
        emailLog.setAttachmentSize(attachment != null ? attachment.length : 0);
        emailLog.setTimestamp(LocalDateTime.now());

        emailLogRepository.save(emailLog);
    }
}
