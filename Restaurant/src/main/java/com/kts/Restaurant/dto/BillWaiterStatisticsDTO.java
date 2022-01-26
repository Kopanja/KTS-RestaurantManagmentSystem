package com.kts.Restaurant.dto;

import com.kts.Restaurant.model.BilledItem;
import com.kts.Restaurant.model.User;

import java.util.Date;
import java.util.List;

public class BillWaiterStatisticsDTO {
    public double price;
    public double cost;

    @Override
    public String toString() {
        return "BillWaiterStatisticsDTO{" +
                "price=" + price +
                ", cost=" + cost +
                ", date=" + date +
                '}';
    }

    public Date date;

    public BillWaiterStatisticsDTO() {
        super();
    }

    public BillWaiterStatisticsDTO(double price, double cost, Date date) {
        this.price = price;
        this.cost = cost;
        this.date = date;
    }
}
