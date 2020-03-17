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

    @Override
    public void addAllCustomers(List<Customer> customers) {
        customerRepo.saveAll(customers);
    }

    @Override
    public void deleteCustomer(int customer_id) {
        customerRepo.deleteById(customer_id);
    }

    @Override
    public void modifyCustomer(Customer customer)
    {
        List<Customer> customers = ( List<Customer>)customerRepo.findAll();
        boolean flagForCustomerId=false;
        boolean flagForAddressId=false;

        for(Customer customer1 : customers){
            if(customer1.getCustomer_id()== customer.getCustomer_id()){
                flagForCustomerId=true;

                if(customer.getAddress().getAddress_id() == customer1.getAddress().getAddress_id()){
                    flagForAddressId=true;
                    customerRepo.save(customer);
                }
                else{
                    System.out.println("Customer's address can't modify because this is not available in database");
                }
            }
        }
        if(flagForCustomerId && flagForAddressId){
           System.out.println("Customer is modified");
        }
        else{
            System.out.println("Customer is not modified, because the customer_id or address_id is not matched with existing customer");
        }
    }
}
