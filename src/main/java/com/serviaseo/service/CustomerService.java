package com.serviaseo.service;

import com.serviaseo.model.Customer;
import com.serviaseo.repository.CustomerRepository;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.EntityManager;



import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;


    public Boolean checkCustomerExists(String email) {
        Query query = entityManager.createNativeQuery("SELECT check_customer_exists(:email)");
        query.setParameter("email", email);
        return (Boolean) query.getSingleResult();
    }

    public void registerNewCustomer(String name, String email, String phone, String address) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("register_new_customer");
        query.registerStoredProcedureParameter(1, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter(1, name);
        query.setParameter(2, email);
        query.setParameter(3, phone);
        query.setParameter(4, address);

        query.execute();
    }

    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer registerNewCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());
        if (existingCustomer.isPresent()) {
            throw new IllegalArgumentException("A customer with this email already exists.");
        }
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
