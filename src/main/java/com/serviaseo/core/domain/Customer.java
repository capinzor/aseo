package com.serviaseo.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "clientes")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Invoice> invoices;
}