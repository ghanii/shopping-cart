package com.poc.poc.controller;

import com.poc.poc.model.Customer;
import com.poc.poc.model.FinalTransaction;
import com.poc.poc.model.Item;
import com.poc.poc.service.FinalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("final-transaction")
public class FinalTransactionController {
    @Autowired
    private FinalTransactionService finalTransactionService;

    @GetMapping("get-final-transactions")
    public List<FinalTransaction> getFinalTransactions(){

        LocalDate date1 = LocalDate.of(2020, Month.FEBRUARY,20);
        LocalDate date2 = LocalDate.of(2020,Month.MARCH,02);
        finalTransactionService.getTopCustomerInBetweenGivenDate(date1,date2);
        return finalTransactionService.getFinalTransactions();
    }

    @GetMapping("get-top-customer")
    public List<Customer> getTopCustomerInBetweenGivenDate(LocalDate start, LocalDate end){

        return finalTransactionService.getTopCustomerInBetweenGivenDate(start,end);
    }

    @GetMapping("get-inactive-customer")
    public List<Customer> getInactiveCustomerInBetweenGivenDate(LocalDate start, LocalDate end){

        return finalTransactionService.getInactiveCustomerInBetweenGivenDate(start,end);
    }

    @GetMapping("get-top-sold-items")
    public List<Item> getTopSoldItemsInBetweenGivenDate(LocalDate start, LocalDate end){

        return finalTransactionService.getTopNSoldItemsInBetweenGivenDate(start,end);
    }
}
