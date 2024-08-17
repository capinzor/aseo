package com.serviaseo.ports.input;

import com.serviaseo.core.domain.Product;

import java.util.List;

public interface ProductUseCase {
    List<Product> listProducts();
    Product addProduct(Product product);
    Product getProductById(Long id);
}