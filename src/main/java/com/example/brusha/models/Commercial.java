package com.example.brusha.models;


import javax.persistence.*;
import java.util.Set;

// fortæller at her skal der checkes for en database klasse
@Entity
public class Commercial {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // attributter til oprettelse af objekt med constructor. her er der så relationer med
    String commercial;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commercial", orphanRemoval = false)
    private Set<Product> products;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commercial", orphanRemoval = false)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
