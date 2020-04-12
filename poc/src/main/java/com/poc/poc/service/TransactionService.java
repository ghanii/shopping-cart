package com.poc.poc.service;

import com.poc.poc.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface TransactionService {

    public void addTransaction(Transaction transaction);

    public void addTransactionByDefault();

    public List<Transaction> getTransactions();

    public List<Transaction> getTransactionsForCustomerId(int customerId);

    public List<Transaction> getTransactionsForCustomerIdAndDateOfPurchase(int customerId, LocalDate date);

    public void getTransactionForDateOfPurchage(LocalDate date);


}
