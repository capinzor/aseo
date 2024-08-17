package com.serviaseo.ports.input;

import com.serviaseo.core.domain.Invoice;
import com.serviaseo.core.domain.InvoiceDetail;
import java.util.List;

public interface InvoiceUseCase {
    Invoice createInvoice(Invoice invoice, List<InvoiceDetail> invoiceDetails);
    List<Invoice> listInvoices();
    Invoice getInvoiceById(Long id);
}