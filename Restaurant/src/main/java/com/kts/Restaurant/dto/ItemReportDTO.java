package com.kts.Restaurant.dto;

public class ItemReportDTO {
    private String name;

    private Integer amount;

    private Double cost;

    private Double price;

    private Double profit;

    public ItemReportDTO(String name, Integer amount, Double cost, Double price, Double profit) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
        this.price = price;
        this.profit = profit;
    }

    public ItemReportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "ItemReportDTO{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                ", price=" + price +
                ", profit=" + profit +
                '}';
    }
}
