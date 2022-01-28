package com.kts.Restaurant.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WaiterReportDTO {
    private String firstname;

    private String lastname;

    private Double profit;

    private Double sumOfBills;

    private List<ItemReportDTO> itemReportDTOS;

    public WaiterReportDTO() {
    }

    public WaiterReportDTO(String firstname, String lastname, Double profit, Double sumOfBills, List<ItemReportDTO> dtos) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profit = profit;
        this.sumOfBills = sumOfBills;
        this.itemReportDTOS = dtos;
    }

    public WaiterReportDTO(String firstname, String lastname, Double profit, Double sumOfBills) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profit = profit;
        this.sumOfBills = sumOfBills;
        this.itemReportDTOS = new ArrayList<>();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getSumOfBills() {
        return sumOfBills;
    }

    public void setSumOfBills(Double sumOfBills) {
        this.sumOfBills = sumOfBills;
    }

    public List<ItemReportDTO> getItemReportDTOMap() {
        return itemReportDTOS;
    }

    public void setItemReportDTOMap(List<ItemReportDTO> itemReportDTOMap) {
        this.itemReportDTOS = itemReportDTOMap;
    }

    @Override
    public String toString() {
        return "WaiterReportDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", profit=" + profit +
                ", sumOfBills=" + sumOfBills +
                ", itemReportDTOMap=" + itemReportDTOS +
                '}';
    }
}
