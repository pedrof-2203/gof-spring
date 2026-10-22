package com.gof.spring.customer.infrastructure.repositories;

import com.gof.spring.customer.domain.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
