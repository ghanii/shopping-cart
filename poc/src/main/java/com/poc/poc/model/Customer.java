package com.poc.poc.model;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int customer_id;
    @Column
    private String customer_name;
    @OneToOne
    private Address address;
    @Column
    private int phone_no;
    @Column
    private Level level; //(Silver/Gold/Platinum)

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", address=" + address +
                ", phone_no=" + phone_no +
                ", level=" + level +
                '}';
    }


}
