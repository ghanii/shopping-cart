package com.poc.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    private int transaction_id;
    @Column
    private int item_id;
    @Column
    private int quantity;
    @Column
    private Double amount;
    @Column
    private int customer_id;

    /**
     * dop - Date of purchase
     */
    @Column
    private LocalDate dop;

    public Transaction() {
    }

    public Transaction(int transaction_id, int item_id, int quantity, Double amount, int customer_id, LocalDate dop) {
        this.item_id = item_id;
        this.quantity = quantity;
        this.amount = amount;
        this.customer_id = customer_id;
        this.dop = dop;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", item_id=" + item_id +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", customer_id=" + customer_id +
                ", dop=" + dop +
                '}';
    }
}
