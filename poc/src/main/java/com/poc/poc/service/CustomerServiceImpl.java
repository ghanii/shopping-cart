package com.poc.poc.service;

import com.poc.poc.model.Address;
import com.poc.poc.model.Customer;
import com.poc.poc.model.Level;
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
    public Address getAddressByCustId(int customer_id) {

        Customer customer;
        Optional<Customer> option = customerRepo.findById(customer_id);
        if(option.isPresent()){
            customer = option.get();
        }else{
            return null;
        }
        return customer.getAddress();
    }

    @Override
    public void saveAllCustomers(List<Customer> customers) {
        customerRepo.saveAll(customers);
    }

    @Override
    public void modifyCustomer(Customer customer) {
        Customer customer1 = getCustomerById(customer.getCustomer_id());
        if(customer1 != null){
            Address address = customer1.getAddress();
            if(address.getAddress_id()== customer.getAddress().getAddress_id()){
                customerRepo.save(customer);
            }
            else{
                System.out.println("Address id "+ customer.getAddress().getAddress_id()+" is not available in database, So we can't modify this customer...");
            }
        }
        else{
            System.out.println("customer id "+customer.getCustomer_id()+" is not available in database, So we can't modify this customer... ");
        }

    }

    //Just for testing
    @Override
    public void saveCustomerWithInternalData() {
        Address address1 = new Address();
        address1.setHouse_no(102);
        address1.setCity("bangalore");
        address1.setState("Karnataka");
        address1.setCountry("india");
        address1.setPincode(560067);

        Customer customer1 = new Customer();
        customer1.setCustomer_id(78);
        customer1.setCustomer_name("shubham");
        customer1.setAddress(address1);
        customer1.setPhone_no(895623457);
        customer1.setLevel(Level.SILVER);
        customerRepo.save(customer1);
    }


    public void addAllCustomers(List<Customer> customers) {
        customerRepo.saveAll(customers);
    }

    @Override
    public void deleteCustomer(int customer_id) {
        customerRepo.deleteById(customer_id);
    }
   
}
