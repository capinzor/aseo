package com.serviaseo.rest;


import com.serviaseo.model.Customer;
import com.serviaseo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    private ResponseEntity<List<Customer>> getAllCustomers() {

        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping("/exists")
    public ResponseEntity<Boolean> checkCustomerExists(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        return ResponseEntity.ok(customerService.checkCustomerExists(email));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerCustomer(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        String email = requestBody.get("email");
        String phone = requestBody.get("phone");
        String address = requestBody.get("address");
        customerService.registerNewCustomer(name, email, phone, address);
        return ResponseEntity.ok().build();
    }
}