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

    /**
     * get all customers
     * */
    @GetMapping("/get-customers")
    public List<Customer> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        return customers;
    }
    /**
     * get a customer by customer_id
     * */
    @GetMapping("/get-customer/{customer_id}")
    public Customer getCustomerById(@PathVariable int customer_id){
        return customerService.getCustomerById(customer_id);

    }
    /**
     * add a customer
     * */
    @PostMapping("/add-customer")
    public Customer addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return customer;
    }

    /**
     * add all customers
     * */
    @PostMapping("/add-all-customers")
    public void addAllCustomers(@RequestBody List<Customer> customers)
    {
        customerService.addAllCustomers(customers);
    }

    /**
     * delete a customer
     * */

    @DeleteMapping("delete-customer/{customer_id}")
    public void deleteCustomer(@PathVariable int customer_id)
    {
        customerService.deleteCustomer(customer_id);
    }

    /**
     * delete a customer
     * */
    @PutMapping("edit-customer")
    public void modifyCustomer(@RequestBody Customer customer){
        customerService.modifyCustomer(customer);
    }

}
