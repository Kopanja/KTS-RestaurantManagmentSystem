package com.kts.Restaurant.dto;

import com.kts.Restaurant.model.User;
import org.springframework.data.neo4j.core.support.DateString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillCreateDTO {
    public double price;
    public double cost;
    public Date date;

    public BillCreateDTO() {
        super();
    }


    @Override
    public String toString() {
        return "BillCreateDTO{" +
                "price=" + price +
                ", cost=" + cost +
                ", date=" + date +
                '}';
    }

    public BillCreateDTO(double cost, double price, Date date) {
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

}
