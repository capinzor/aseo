package com.serviaseo.service;

import com.serviaseo.model.InvoiceDetail;
import com.serviaseo.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public List<InvoiceDetail> findAll() {
        return invoiceDetailRepository.findAll();
    }

    public Optional<InvoiceDetail> findById(Long id) {
        return invoiceDetailRepository.findById(id);
    }

    public InvoiceDetail save(InvoiceDetail invoiceDetail) {
        return invoiceDetailRepository.save(invoiceDetail);
    }

    public void deleteById(Long id) {
        invoiceDetailRepository.deleteById(id);
    }
}
