package com.poc.poc.service;

import com.poc.poc.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {

    public List<Customer> getCustomers();
    public Customer getCustomerById(int customer_id);
    public void addCustomer(Customer customer);
}
