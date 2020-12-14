package com.example.brusha.models;

import java.util.Date;

public class Product {

    int customerID;
    String name;
    String producer;
    double price;
    Date date;
    boolean active;

    public Product(int customerID, String name, String producer, double price, Date date, boolean active) {
        this.customerID = customerID;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.date = date;
        this.active = active;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    @Override
    public String toString() {
        return "Product{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", active=" + active +
                '}';
    }
}
