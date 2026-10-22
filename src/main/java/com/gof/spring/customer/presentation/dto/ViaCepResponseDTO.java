package com.gof.spring.customer.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCepResponseDTO {

    @JsonProperty("cep")
    private String zipCode;

    @JsonProperty("logradouro")
    private String street;

    @JsonProperty("bairro")
    private String neighbourhood;

    @JsonProperty("localidade")
    private String city;

    @JsonProperty("uf")
    private String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}