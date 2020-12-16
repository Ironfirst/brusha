package com.example.brusha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    String name;
    String producer;
    double price;
    Date date;
    boolean active;

    // relation af attributer "primary / foreign key"

    //many to one relation til statistic //--- skal måske være en mange til mange istedet da mange produkter kan have mana statestikker
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_id")

    @JsonBackReference
    private Statistic statistics;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commercial_id")

    //her ignoreres parent property i child objekt med JsonBackReference for at undgå uendeligt loop
    @JsonBackReference
    private Commercial commercials;

    public Product(){}

    public Product( String name, String producer, double price, Date date, boolean active) {

        this.name = name;
        this.producer = producer;
        this.price = price;
        this.date = date;
        this.active = active;
        this.commercials = commercials;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Commercial getCommercials() {
        return commercials;
    }

    public void setCommercials(Commercial commercials) {
        this.commercials = commercials;
    }

    public Statistic getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistic statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", active=" + active +
                ", commercial=" + commercials +
                '}';
    }
}
