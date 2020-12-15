package com.example.brusha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Date date;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statistic", orphanRemoval = false)
    private Set<Product> products;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statistic", orphanRemoval = false)
    private Set<Customer> customers;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statistic", orphanRemoval = false)
    private Set<Subscription> subscriptions;

    public Statistic(){}

    public Statistic(Customer customerID, Subscription subscriptionID, Date date) {
        this.date = date;

        this.subscriptions = subscriptions;
        this.customers = customers;
        this.products = products;
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

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", date=" + date +
                ", products=" + products +
                ", customers=" + customers +
                ", subscriptions=" + subscriptions +
                '}';
    }
}
