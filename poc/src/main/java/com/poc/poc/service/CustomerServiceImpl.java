package com.poc.poc.service;

import com.poc.poc.model.Customer;
import com.poc.poc.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<Customer> getCustomers() {

        List<Customer> customers = (List<Customer>)customerRepo.findAll();
        return customers;
    }

    @Override
    public Customer getCustomerById(int customer_id) {
        Customer customer=null;
        Optional<Customer> option = customerRepo.findById(customer_id);
        if(option.isPresent())
        {
            customer = option.get();
        }
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }
}
