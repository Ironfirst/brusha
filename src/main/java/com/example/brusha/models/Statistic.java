package com.example.brusha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Date date;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statistics", orphanRemoval = false)
    private Set<Product> products;

    // prøv at lave many to many relation på customer / commercial. husk ret på customer også
// tester lige om dette virker istedet for en "many to one relation
//@ManyToMany(cascade = CascadeType.ALL)
////specificer join tabellen
//@JoinTable ( name = "Statistic_customer",
//        joinColumns = @JoinColumn(name = "statistic_id"),
//        inverseJoinColumns = @JoinColumn(name = "customer_id")
//)
//private Set<Customer> customers = new HashSet<>();


// ------- // many to one customer relation
//    // many to one customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    //for at undgå uendeligt loop, ignoreres parent property i childbojekt med JsonBackReference
    @JsonBackReference
    private Customer customers;

    // subscriptions
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statistics", orphanRemoval = false)
    private Set<Subscription> subscriptions;

    public Statistic(){}

    public Statistic(Customer customerID, Subscription subscriptionID, Date date) {
        this.customers = customers;
        this.date = date;
        this.subscriptions = subscriptions;
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

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
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


}
