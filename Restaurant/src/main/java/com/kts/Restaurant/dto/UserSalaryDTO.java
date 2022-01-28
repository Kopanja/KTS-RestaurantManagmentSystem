package com.kts.Restaurant.dto;

import com.kts.Restaurant.model.Credentials;

public class UserSalaryDTO {

    private String firstname;

    private String lastname;

    private String role;

    private Boolean active;

    private Double totalSalary;

    public UserSalaryDTO() {
    }

    public UserSalaryDTO(String firstname, String lastname, String role, Boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    @Override
    public String toString() {
        return "UserSalaryDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                ", totalSalary=" + totalSalary +
                '}';
    }
}
