package com.example.brusha.models;

import java.util.Date;

public class Statistic {

    Customer customerID;
    Subscription subscriptionID;
    Product productID;
    Date date;

    public Statistic(Customer customerID, Subscription subscriptionID, Product productID, Date date) {
        this.customerID = customerID;
        this.subscriptionID = subscriptionID;
        this.productID = productID;
        this.date = date;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Subscription getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(Subscription subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
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
                "customerID=" + customerID +
                ", subscriptionID=" + subscriptionID +
                ", productID=" + productID +
                ", date=" + date +
                '}';
    }
}
