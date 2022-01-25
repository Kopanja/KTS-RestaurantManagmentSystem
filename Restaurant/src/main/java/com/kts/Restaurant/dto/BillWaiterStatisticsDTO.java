package com.kts.Restaurant.dto;

import com.kts.Restaurant.model.BilledItem;
import com.kts.Restaurant.model.User;

import java.util.Date;
import java.util.List;

public class BillWaiterStatisticsDTO {
    private double price;
    private double cost;
//    private Date date;
    private User waiter;

    public BillWaiterStatisticsDTO(double price, double cost, User waiter) {
        this.price = price;
        this.cost = cost;
//        this.date = date;
        this.waiter = waiter;
    }
}
