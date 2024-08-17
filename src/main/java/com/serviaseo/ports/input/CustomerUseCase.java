package com.serviaseo.ports.input;

import com.serviaseo.core.domain.Customer;
import java.util.Optional;

public interface CustomerUseCase {
    Optional<Customer> checkCustomer(String email);
    Customer registerCustomer(Customer customer);
}