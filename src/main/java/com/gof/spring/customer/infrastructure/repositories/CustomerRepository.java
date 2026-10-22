package com.gof.spring.customer.infrastructure.repositories;

import com.gof.spring.customer.domain.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
