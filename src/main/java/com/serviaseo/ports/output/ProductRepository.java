package com.serviaseo.ports.output;

import com.serviaseo.core.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
}