package com.serviaseo.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cleaning_types")
@Data
@AllArgsConstructor
public class CleaningType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "cleaningType", cascade = CascadeType.ALL)
    private List<Invoice> invoices;

}
