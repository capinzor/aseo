package com.serviaseo.ports.output;

import com.serviaseo.core.domain.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);
    List<Invoice> findAll();
    Optional<Invoice> findById(Long id);
}