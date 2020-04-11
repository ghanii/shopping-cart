package com.poc.poc.controller;

import com.poc.poc.model.Transaction;
import com.poc.poc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("add-transaction")
    public void addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
    }

    //just for testing
    @PostMapping("add-transaction-without-data")
    public void addTransactionByDefault(){
        transactionService.addTransactionByDefault();
    }

    @GetMapping("get-transactions")
    public List<Transaction> getTransaction(){
        return transactionService.getTransactions();
    }

    @GetMapping("get-transactions-by-customer-id/{customerId}")
    public List<Transaction> getTransactionsByCustomerId(@PathVariable int customerId){
        return transactionService.getTransactionsForCustomerId(customerId);
    }
    @GetMapping("get-transactions-by-customer-ids/{customerId}")
    public List<Transaction> getTransactionsByCustomerIdAndDateOfPurchase(@PathVariable("customerId") int customerId, @RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return transactionService.getTransactionsForCustomerIdAndDateOfPurchase(customerId,date);
    }

}
