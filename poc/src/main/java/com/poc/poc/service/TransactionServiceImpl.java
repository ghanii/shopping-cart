package com.poc.poc.service;

import com.poc.poc.model.FinalTransaction;
import com.poc.poc.model.Transaction;
import com.poc.poc.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    FinalTransactionService finalTransactionService;

    @Override
    public void addTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    @Override
    public void addTransactionByDefault() {
        Transaction transaction1 = new Transaction(1,1, 2, 90.0, 2, LocalDate.now());
        Transaction transaction2 = new Transaction(2,1, 5, 450.0, 2, LocalDate.now());
        transactionRepo.save(transaction1);
        transactionRepo.save(transaction2);
    }

    @Override
    public List<Transaction> getTransactions() {

        return (List<Transaction>) transactionRepo.findAll();
    }

    @Override
    public List<Transaction> getTransactionsForCustomerId(int customerId) {

        List<Transaction> transactionsOfACustomer = transactionRepo.findByCustomerId(customerId);
        for (Transaction t : transactionsOfACustomer) {
            System.out.println(t);
        }

        return transactionsOfACustomer;

    }
    // Need to check if we are using it or not
    @Override
    public List<Transaction> getTransactionsForCustomerIdAndDateOfPurchase(int customerId, LocalDate date) {
        List<Transaction> transactionsOfACustomer = transactionRepo.findByCustomerIdAndDateOfPurchase(customerId, date);
        int totalAmount = 0;
        FinalTransaction finalTransaction = new FinalTransaction();
        for (Transaction t : transactionsOfACustomer) {
            System.out.println(t);
            totalAmount += t.getAmount();

        }
        finalTransaction.setTotalAmount(totalAmount);
        finalTransaction.setCustomer_id(customerId);
        finalTransaction.setDop(date);
        finalTransactionService.saveFinalTransaction(finalTransaction);

        return transactionsOfACustomer;
    }

    private static int finalTransactionId=1;
    @Override
    public void getTransactionForDateOfPurchage(LocalDate date) {

        List<Transaction> transactionsOfACustomer = transactionRepo.findByDateOfPurchase(date);
        Set<Integer> customerIds = new LinkedHashSet<>();

        for (Transaction transaction : transactionsOfACustomer) {
            customerIds.add(transaction.getCustomer_id());
        }

        for (int customerId : customerIds) {
            int totalAmount = 0;
            for (Transaction t : transactionsOfACustomer) {

                if (customerId == t.getCustomer_id()) {
                    totalAmount += t.getAmount();
                }
            }
            FinalTransaction finalTransaction = new FinalTransaction(finalTransactionId++,totalAmount, customerId, date);
            System.out.println("Final Transaction : " + finalTransaction);
            finalTransactionService.saveFinalTransaction(finalTransaction);
        }


    }

}
