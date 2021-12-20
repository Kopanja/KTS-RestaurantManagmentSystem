package com.kts.Restaurant.dto;

import com.kts.Restaurant.model.Role;

import java.util.List;

public class UserDTO {


    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private String role;

    private String pin;

    private double salaryAmount;

    public UserDTO() {

    }


    public UserDTO(String firstname, String lastname, String username, String password, String role, String pin, double salaryAmount) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.pin = pin;
        this.salaryAmount = salaryAmount;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }
}
