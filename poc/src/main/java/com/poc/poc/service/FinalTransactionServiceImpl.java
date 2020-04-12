package com.poc.poc.service;

import com.poc.poc.model.*;
import com.poc.poc.repo.FinalTransactionRepo;
import com.poc.poc.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class FinalTransactionServiceImpl implements FinalTransactionService {

    @Autowired
    FinalTransactionRepo finalTransactionRepo;

    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    ItemService itemService;


    @Override
    public void saveFinalTransaction(FinalTransaction fTransaction) {
        finalTransactionRepo.save(fTransaction);
    }

    @Override
    public List<FinalTransaction> getFinalTransactions() {
        List<FinalTransaction> finalTransactions = (List<FinalTransaction>) finalTransactionRepo.findAll();
        return finalTransactions;
    }

    //////////////////////////////////////////////////         Reporting Api         ////////////////////////////////////////////////////////


    //Give me top n high spending customer between given dates.

    @Override
    public List<Customer> getTopCustomerInBetweenGivenDate(LocalDate start, LocalDate end) {

        List<FinalTransaction> finalTransactions = finalTransactionRepo.findAllByDateOfPurchaseBetween(start,end);
        Set<Integer> customerIds = new LinkedHashSet<>();
        for(FinalTransaction ft : finalTransactions){
            customerIds.add(ft.getCustomer_id());
            System.out.println("................,,,,,,,,,,,,,..............,,,,,,,,,.........."+ft);
        }
        Map<Integer,Integer> customersWithTransactions = new LinkedHashMap<>();

        for(Integer cust_id : customerIds){
            int finalAmount = 0;

            for(FinalTransaction ft : finalTransactions){

                if(cust_id == ft.getCustomer_id()){
                    finalAmount += ft.getTotalAmount();
                }
            }
            customersWithTransactions.put(cust_id,finalAmount);
        }

        Map<Integer,Integer> customersWithTopTransactions = sortByValue(customersWithTransactions);
        Set<Integer> custIds = customersWithTopTransactions.keySet();
        for(Integer id : custIds){
            System.out.println("Key :::::::  "+id+" Value ::::::: " +customersWithTopTransactions.get(id));
        }
        int n=3;
        List<Customer> listOfCustomers = new ArrayList<>();
        for(Integer custId : custIds){
            if(n > 0) {
                System.out.println("Customer ::::::::::::::::::::::::"+custId);
                listOfCustomers.add(customerService.getCustomerById(custId));
                n--;
            }
        }


        return listOfCustomers;
    }

    //Give inactive customer between given dates

    @Override
    public List<Customer> getInactiveCustomerInBetweenGivenDate(LocalDate start, LocalDate end) {

        //fetch customer ids from final transaction table
        List<FinalTransaction> finalTransactions = finalTransactionRepo.findAllByDateOfPurchaseBetween(start,end);
        Set<Integer> customerIds = new LinkedHashSet<>();
        for(FinalTransaction ft : finalTransactions){
            customerIds.add(ft.getCustomer_id());
            System.out.println("................,,,,,,,,,,,,,..............,,,,,,,,,.........."+ft);
        }
        // Fetch customer ids from customer table
        List<Customer> customers = customerService.getCustomers();
        Set<Integer> custIds = new LinkedHashSet<>();
        for(Customer cust : customers){
            custIds.add(cust.getCustomer_id());
        }
        //Compare and add customer to the list
        List<Customer> inactiveCustomerList = new ArrayList<>();
        for(Integer id : custIds)
        {
            if(!customerIds.contains(id)){
                inactiveCustomerList.add(customerService.getCustomerById(id));
            }
        }

        return inactiveCustomerList;
    }

    //Give me top n sold item details within given dates.

    @Override
    public List<Item> getTopNSoldItemsInBetweenGivenDate(LocalDate start, LocalDate end) {

        List<Transaction> transactions = transactionRepo.findAllByDateOfPurchaseBetween(start,end);
        Set<Integer> item_ids = new LinkedHashSet<>();
        for(Transaction transaction : transactions){
            item_ids.add(transaction.getItem_id());
        }

        Map<Integer,Integer> itemsQuantity = new LinkedHashMap<>();
        for(Integer item_id : item_ids){
            int quantity=0;
            for(Transaction transaction : transactions){

                if(item_id == transaction.getItem_id()){
                    quantity += transaction.getQuantity();
                }
            }
            itemsQuantity.put(item_id,quantity);
        }

        Map<Integer, Integer> itemsWithSortedQuantity = sortByValue(itemsQuantity);

        int n=3;
        List<Item> listOfItems = new ArrayList<>();
        for(Integer itemId : item_ids){
            if(n > 0) {
                System.out.println("Item ::::::::::::::::::::::::"+itemId);
                listOfItems.add(itemService.getItem(itemId));
                n--;
            }
        }
        return listOfItems;
    }

    /*Upgrade/Downgrade customers on Dec 31st as per below requirement: (Batch job)
              Silver - Default
              Gold - Transaction >= 100000 (In a year)
              Platinum - Transaction >=500000 (In a year)*/


    @Override
    public void upgradeDowngradeCustomerLevel(LocalDate start, LocalDate end) {

        List<FinalTransaction> finalTransactions = finalTransactionRepo.findAllByDateOfPurchaseBetween(start,end);
        Set<Integer> customerIds = new LinkedHashSet<>();
        for(FinalTransaction ft : finalTransactions){
            customerIds.add(ft.getCustomer_id());
            System.out.println("................,,,,,,,,,,,,,..............,,,,,,,,,.........."+ft);
        }
        Customer customer;
        for(Integer cust_id : customerIds){
            int finalAmount = 0;

            for(FinalTransaction ft : finalTransactions){

                if(cust_id == ft.getCustomer_id()){
                    finalAmount += ft.getTotalAmount();
                }
            }

            if(finalAmount >= 100000 && finalAmount < 500000){
                customer=customerService.getCustomerById(cust_id);
                customer.setLevel(Level.GOLD);
                customerService.modifyCustomer(customer);
            }
            else if(finalAmount >= 500000){
                customer=customerService.getCustomerById(cust_id);
                customer.setLevel(Level.PLATINUM);
                customerService.modifyCustomer(customer);
            }
            else{
                customer= customerService.getCustomerById(cust_id);
                customer.setLevel(Level.SILVER);
                customerService.modifyCustomer(customer);
            }

        }

    }

    //Utility method to sort a map
    private Map<Integer,Integer> sortByValue(Map<Integer,Integer> hm){

        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
