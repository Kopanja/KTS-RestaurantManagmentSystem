package com.kts.Restaurant.dto;

public class WaiterStatistictsResponseDTO {
    private String name;
    private String lastname;
    private String role;
    private Double profit;

    public WaiterStatistictsResponseDTO() {
        super();
    }

    public WaiterStatistictsResponseDTO(String name, String lastname, String role, Double profit) {
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public Double getProfit() {
        return profit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
