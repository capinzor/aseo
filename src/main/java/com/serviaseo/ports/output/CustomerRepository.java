package com.serviaseo.ports.output;

import com.serviaseo.core.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findByEmail(String email);
    Customer save(Customer customer);
}