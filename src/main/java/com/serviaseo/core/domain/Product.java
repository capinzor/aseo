package com.serviaseo.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<InvoiceDetail> invoiceDetails;
}
