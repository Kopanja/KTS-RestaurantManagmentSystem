package com.kts.Restaurant.dto;

import com.kts.Restaurant.util.DateStringConverter;
import org.springframework.data.neo4j.core.convert.ConvertWith;

import java.util.Date;

public class SalaryDTO {

    private double salaryAmount;

    private Date since;

    private Date to;

    private Boolean active;



    public SalaryDTO() {
    }

    public SalaryDTO(double salaryAmount, Date since, Date to, Boolean active) {
        this.salaryAmount = salaryAmount;
        this.since = since;
        this.to = to;
        this.active = active;
    }


    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salaryAmount=" + salaryAmount +
                ", since=" + since +
                ", to=" + to +
                ", active=" + active +
                '}';
    }
}
