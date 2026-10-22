package com.gof.spring.customer.application.service;

import com.gof.spring.customer.presentation.dto.CreateCustomerDTO;
import com.gof.spring.customer.presentation.dto.UpdateCustomerDTO;
import com.gof.spring.customer.domain.entities.Customer;

public interface CustomerService {

    Iterable<Customer> findAll();

    void create(CreateCustomerDTO createCustomerDTO);

    Customer findById(Long id);

    void update(Long id, UpdateCustomerDTO updateCustomerDTO);

    void delete(Long id);
}
