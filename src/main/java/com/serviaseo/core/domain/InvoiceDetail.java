package com.serviaseo.core.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "invoice_details")
@Data
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private Double unitPrice;
    private Double subtotal;
}
