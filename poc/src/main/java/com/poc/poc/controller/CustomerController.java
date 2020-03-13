package com.poc.poc.controller;

import com.poc.poc.model.Customer;
import com.poc.poc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-customers")
    public List<Customer> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        return customers;
    }

    @GetMapping("/get-customer/{customer_id}")
    public Customer getCustomerById(@PathVariable int customer_id){
        return customerService.getCustomerById(customer_id);

    }

    @PostMapping("/add-customer")
    public Customer addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return customer;
    }
}
