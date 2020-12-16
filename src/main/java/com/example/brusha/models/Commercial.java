package com.example.brusha.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

// fortæller at her skal der checkes for en database klasse
@Entity
public class Commercial {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commercialId;

    // attributter til oprettelse af objekt med constructor. her er der så relationer med
    String commercial;

    // mangler mange til mange relation til subscriptions " mange subscriptions kan have mange commercial

    //json skal kun følge referencen den ene vej
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commercials", orphanRemoval = false)
    private Set<Product> products;

    //Json skal kun følge referencen den ene vej
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commercials", orphanRemoval = false)
    private Set<Customer> customers;


    public Commercial(){}

    public Commercial(String commercial,  Product product) {

        this.commercial = commercial;

        this.products = products;
        this.customers = customers;
    }

    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public Long getCommercialId() {
        return commercialId;
    }

    public void setCommercialId(Long commercialId) {
        this.commercialId = commercialId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
