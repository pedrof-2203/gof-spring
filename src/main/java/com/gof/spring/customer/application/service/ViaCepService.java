package com.gof.spring.customer.application.service;

import com.gof.spring.customer.presentation.dto.ViaCepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{zipCode}/json/")
    ViaCepResponseDTO findAddress(@PathVariable("zipCode") String zipCode);

}
