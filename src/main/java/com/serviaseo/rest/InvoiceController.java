package com.serviaseo.rest;

import com.serviaseo.model.Invoice;
import com.serviaseo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create")
    public ResponseEntity<Long> createInvoiceAndDetails(@RequestBody Map<String, Object> requestBody) {
        String issueDate = (String) requestBody.get("issueDate");
        Long cleaningTypeId = ((Number) requestBody.get("cleaningTypeId")).longValue();
        Long customerId = ((Number) requestBody.get("customerId")).longValue();
        String detailsJson = (String) requestBody.get("detailsJson");
        Long invoiceId = invoiceService.createInvoiceAndDetails(issueDate, cleaningTypeId, customerId, detailsJson);
        return new ResponseEntity<>(invoiceId, HttpStatus.CREATED);
    }
    @PostMapping("/send")
    public ResponseEntity<Void> sendInvoice(@RequestBody Map<String, String> requestBody) {
        Long invoiceId = Long.parseLong(requestBody.get("invoiceId"));
        String to = requestBody.get("to");
        String subject = requestBody.get("subject");
        String body = requestBody.get("body");

        invoiceService.sendInvoiceByEmail(invoiceId, to, subject, body);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceService.findById(id);
        return invoice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
