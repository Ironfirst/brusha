package com.example.brusha.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Date startDate;
    Date endDate;
    Time time;
    boolean active;

    @JsonManagedReference
    @OneToOne ( cascade = CascadeType.ALL, orphanRemoval = false)
    private Product product;

    @JsonManagedReference
    @OneToOne ( cascade = CascadeType.ALL, orphanRemoval = false)
    private Customer customer;


    public Subscription(){}

    public Subscription( Date startDate, Date endDate, Time time, boolean active) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.active = active;
        this.customer = customer;
        this.product= product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", time=" + time +
                ", active=" + active +
                '}';
    }
}
