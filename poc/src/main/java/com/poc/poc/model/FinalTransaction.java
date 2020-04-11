package com.poc.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FinalTransaction {

    @Id
    private int finalTransaction_id;

    @Column
    private double totalAmount;

    @Column
    private int customer_id;

    @Column
    private LocalDate dop;

    public FinalTransaction() {
    }

    public FinalTransaction(int finalTransaction_id, double totalAmount, int customer_id, LocalDate dop) {
        this.finalTransaction_id = finalTransaction_id;
        this.totalAmount = totalAmount;
        this.customer_id = customer_id;
        this.dop = dop;
    }

    public int getFinalTransaction_id() {
        return finalTransaction_id;
    }

    public void setFinalTransaction_id(int finalTransaction_id) {
        this.finalTransaction_id = finalTransaction_id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDate getDop() {
        return dop;
    }

    public void setDop(LocalDate dop) {
        this.dop = dop;
    }

    @Override
    public String toString() {
        return "FinalTransaction{" +
                "finalTransaction_id=" + finalTransaction_id +
                ", totalAmount=" + totalAmount +
                ", customer_id=" + customer_id +
                ", dop=" + dop +
                '}';
    }
}
