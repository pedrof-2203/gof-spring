package com.gof.spring.customer.presentation.controllers;

import com.gof.spring.customer.application.service.CustomerService;
import com.gof.spring.customer.presentation.dto.CreateCustomerDTO;
import com.gof.spring.customer.presentation.dto.UpdateCustomerDTO;
import com.gof.spring.customer.domain.entities.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    ResponseEntity<Iterable<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody CreateCustomerDTO createCustomerDTO) {
        customerService.create(createCustomerDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Customer> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        customerService.update(id, updateCustomerDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
