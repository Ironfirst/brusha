package com.example.brusha.models;

import java.sql.Time;
import java.util.Date;

public class Subscription {

    int subscriptionID;
    Date startDate;
    Date endDate;
    Time time;
    boolean active;

    public Subscription(int subscriptionID, Date startDate, Date endDate, Time time, boolean active) {
        this.subscriptionID = subscriptionID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.active = active;
    }

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.subscriptionID = subscriptionID;
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
                "subscriptionID=" + subscriptionID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", time=" + time +
                ", active=" + active +
                '}';
    }
}
