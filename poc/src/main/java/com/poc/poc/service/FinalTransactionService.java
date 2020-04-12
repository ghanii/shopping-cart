package com.poc.poc.service;

import com.poc.poc.model.Customer;
import com.poc.poc.model.FinalTransaction;
import com.poc.poc.model.Item;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface FinalTransactionService {
    public void saveFinalTransaction(FinalTransaction fTransaction);

    public List<FinalTransaction> getFinalTransactions();

    public List<Customer> getTopCustomerInBetweenGivenDate(LocalDate start, LocalDate end);

    public List<Customer> getInactiveCustomerInBetweenGivenDate(LocalDate start, LocalDate end);

    public List<Item> getTopNSoldItemsInBetweenGivenDate(LocalDate start, LocalDate end);

    public void upgradeDowngradeCustomerLevel(LocalDate start, LocalDate end);
}
