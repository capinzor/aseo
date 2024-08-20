package com.serviaseo.rest;

import com.serviaseo.model.InvoiceDetail;
import com.serviaseo.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoice-details")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping
    public List<InvoiceDetail> getAllInvoiceDetails() {
        return invoiceDetailService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetail> getInvoiceDetailById(@PathVariable Long id) {
        Optional<InvoiceDetail> invoiceDetail = invoiceDetailService.findById(id);
        return invoiceDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public InvoiceDetail createInvoiceDetail(@RequestBody InvoiceDetail invoiceDetail) {
        return invoiceDetailService.save(invoiceDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceDetail(@PathVariable Long id) {
        invoiceDetailService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
