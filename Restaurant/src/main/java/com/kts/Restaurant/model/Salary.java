package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Date;

@Node
public class Salary {


    @Id
    @GeneratedValue
    private Long id;

    private double salaryAmount;

    private Date since;

    private Date to;

    private Boolean active;

    public Salary() {
        super();
    }

    public Salary(double salaryAmount, Date since, Date to, Boolean active) {
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
}
