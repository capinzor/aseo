package com.serviaseo.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cleaning_types")
@Data
public class CleaningType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "cleaningType", cascade = CascadeType.ALL)
    private List<Invoice> invoices;
}
