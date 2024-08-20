package com.serviaseo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serviaseo.model.Invoice;
import com.serviaseo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockEmailService emailService;

    @Transactional
    public Long createInvoiceAndDetails(String issueDate, Long cleaningTypeId, Long customerId, String detailsJson) {
        java.sql.Date sqlIssueDate = java.sql.Date.valueOf(issueDate);

        String sql = "SELECT create_invoice_and_details(issue_date, cleaning_type_id, customer_id, ?::jsonb)";
        return jdbcTemplate.queryForObject(sql, Long.class, sqlIssueDate, cleaningTypeId, customerId, detailsJson);
    }

    public void sendInvoiceByEmail(Long invoiceId, String to, String subject, String body) {

        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new IllegalArgumentException("Invoice not found"));

        byte[] pdfAttachment = generateInvoicePdf(invoice);

        emailService.sendInvoiceEmail(to, subject, body, pdfAttachment);
    }

    private byte[] generateInvoicePdf(Invoice invoice) {
        String mockPdfContent = "Invoice ID: " + invoice.getInvoiceId() ;
        return mockPdfContent.getBytes();
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
    }

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
