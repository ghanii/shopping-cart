package com.poc.poc.repo;

import com.poc.poc.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction,Integer> {

    List<Transaction> findByCustomerId(int customerId);

    List<Transaction> findByCustomerIdAndDateOfPurchase(int customerId,LocalDate date);

    List<Transaction> findByDateOfPurchase(LocalDate date);

    List<Transaction> findAllByDateOfPurchaseBetween(LocalDate dateOfPurchaseStart,LocalDate dateOfPurchaseEnd);
}
