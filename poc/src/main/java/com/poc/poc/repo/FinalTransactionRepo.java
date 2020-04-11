package com.poc.poc.repo;

import com.poc.poc.model.FinalTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface  FinalTransactionRepo extends CrudRepository<FinalTransaction,Integer> {

    List<FinalTransaction> findAllByDateOfPurchaseBetween(LocalDate dateOfPurchaseStart, LocalDate dateOfPurchaseEnd);
}
