package com.kts.Restaurant.dto;

import java.util.Date;

public class BillCreateRequestDTO {
    public double price;
    public double cost;
    public Date date;

    public BillCreateRequestDTO() {
        super();
    }


    public BillCreateRequestDTO(double cost, double price, Date date) {
        super();
        this.cost = cost;
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public double getCost() {
        return cost;
    }

    public Date getDate() {
        return date;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BillCreateRequestDTO{" +
                "price=" + price +
                ", cost=" + cost +
                ", date='" + date + '\'' +
                '}';
    }
}

