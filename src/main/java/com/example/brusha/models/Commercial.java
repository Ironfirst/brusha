package com.example.brusha.models;

public class Commercial {

    String commercial;
    Customer customer;
    Product product;

    public Commercial(String commercial, Customer customer, Product product) {
        this.commercial = commercial;
        this.customer = customer;
        this.product = product;
    }

    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Commercial{" +
                "commercial='" + commercial + '\'' +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }
}
