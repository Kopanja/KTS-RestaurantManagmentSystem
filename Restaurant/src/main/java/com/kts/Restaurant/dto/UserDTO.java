package com.kts.Restaurant.dto;

import com.kts.Restaurant.model.Role;

import java.util.List;

public class UserDTO {


    private String firstname;

    private String lastname;

    private String role;

    private double salaryAmount;

    private Boolean active;

    public UserDTO() {

    }


    public UserDTO(String firstname, String lastname, String role, double salaryAmount, Boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.salaryAmount = salaryAmount;
        this.active = active;
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

    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
