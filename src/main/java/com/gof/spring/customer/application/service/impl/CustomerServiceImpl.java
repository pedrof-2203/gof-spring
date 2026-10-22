package com.gof.spring.customer.application.service.impl;

import com.gof.spring.customer.application.service.CustomerService;
import com.gof.spring.customer.application.service.ViaCepService;
import com.gof.spring.customer.presentation.dto.CreateCustomerDTO;
import com.gof.spring.customer.presentation.dto.UpdateCustomerDTO;
import com.gof.spring.customer.domain.entities.Address;
import com.gof.spring.customer.infrastructure.repositories.AddressRepository;
import com.gof.spring.customer.domain.entities.Customer;
import com.gof.spring.customer.infrastructure.repositories.CustomerRepository;
import com.gof.spring.customer.presentation.dto.ViaCepResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final AddressRepository addressRepository;

    private final ViaCepService viaCepService;

    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            AddressRepository addressRepository,
            ViaCepService viaCepService
    ) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(CreateCustomerDTO createCustomerDTO) {
        Address address = getAddress(createCustomerDTO.zipCode());

        Customer customer = new Customer();
        customer.setName(createCustomerDTO.name());
        customer.setAddress(address);

        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Customer no found"));
    }

    @Override
    public void update(Long id, UpdateCustomerDTO updateCustomerDTO) {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Address address = getAddress(updateCustomerDTO.zipCode());

        customer.setName(updateCustomerDTO.name());
        customer.setAddress(address);

        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    private Address getAddress(String zipCode) {
        return addressRepository.findById(zipCode).orElseGet(() -> {
            ViaCepResponseDTO response = viaCepService.findAddress(zipCode);
            Address newAddress = new Address();
            newAddress.setZipCode(response.getZipCode());
            newAddress.setStreet(response.getStreet());
            newAddress.setNeighbourhood(response.getNeighbourhood());
            newAddress.setCity(response.getCity());
            newAddress.setState(response.getState());
            return addressRepository.save(newAddress);
        });
    }
}