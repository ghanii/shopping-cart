package com.poc.poc.service;

import com.poc.poc.model.Address;
import com.poc.poc.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomerById(int customer_id);

    public Address getAddressByCustId(int customer_id);

    public void addCustomer(Customer customer);

    public void saveAllCustomers(List<Customer> customers);

    public void modifyCustomer(Customer customer);

    public void deleteCustomer(int customer_id);

    public void saveCustomerWithInternalData();
         
}
