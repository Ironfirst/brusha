package com.example.brusha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    String email;
    int phone;
    String address;
    String cpr;



// relations attributter

    // commercial_id skal evt ændres her eller i commercial model for at sikre samme id navn
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="commercial_id")
    //her ignoreres parent property i child objekt med JsonBackReference for at undgå uendeligt loop
    @JsonBackReference
    private Commercial commercials;


    // subscription relation
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
    private Subscription subscriptions;

//    @ManyToMany( mappedBy = "customers", cascade = CascadeType.ALL)
//    //envejs referance i JSON for at undgå uendeligt loop - ignoreres
//    @JsonIgnore
//    Set<Statistic> statistics;

    //////---------- tester med mange til mange istedet.
    // --------// skal måske laves om til mange til mange relation da mange kunder har mange statestikker =?
    // statistic
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers", orphanRemoval = false)
    private Set<Statistic> statistics;


    // tom constructor til oprettelse af tomme objekter
    public Customer(){}

    public Customer( String name, String email, int phone, String address, String cpr) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cpr = cpr;
        this.statistics = statistics;
    }

    public Long getCustomerId() {
        return id;
    }

    public void setCustomerId(Long customerId) {
        this.id = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commercial getCommercial() {
        return commercials;
    }

    public void setCommercial(Commercial commercial) {
        this.commercials = commercial;
    }

    public Subscription getSubscription() {
        return subscriptions;
    }

    public void setSubscription(Subscription subscription) {
        this.subscriptions = subscription;
    }

    public Set<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(Set<Statistic> statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", cpr='" + cpr + '\'' +
                ", commercial=" + commercials +
                ", subscription=" + subscriptions +
                ", statistics=" + statistics +
                '}';
    }
}
