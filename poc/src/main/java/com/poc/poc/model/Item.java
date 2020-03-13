package com.poc.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private int item_id;
    @Column
    private String item_name;
    @Column
    private double item_price;
    @Column
    private Category category;
    @Column
    private Date mfg_date;
    @Column
    private Date expiry_date;

    public Item() {
    }

    public Item(int item_id, String item_name, double item_price, Category category, Date mfg_date, Date expiry_date) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.category = category;
        this.mfg_date = mfg_date;
        this.expiry_date = expiry_date;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getMfg_date() {
        return mfg_date;
    }

    public void setMfg_date(Date mfg_date) {
        this.mfg_date = mfg_date;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", item_price=" + item_price +
                ", category=" + category +
                ", mfg_date=" + mfg_date +
                ", expiry_date=" + expiry_date +
                '}';
    }
}
