package com.example.brusha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

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
    private Commercial commercial;


    // subscription relation
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
    private Subscription subscription;

    // --------// skal måske laves om til mange til mange relation da mange kunder har mange statestikker =?
    // statistic
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statistic", orphanRemoval = false)
    private Set<Statistic> statistics;


    // tom constructor til oprettelse af tomme objekter
    public Customer(){}

    public Customer( String name, String email, int phone, String address, String cpr) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cpr = cpr;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", cpr='" + cpr + '\'' +
                ", commercial=" + commercial +
                '}';
    }
}
