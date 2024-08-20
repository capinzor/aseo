package com.serviaseo.repository;

import com.serviaseo.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}