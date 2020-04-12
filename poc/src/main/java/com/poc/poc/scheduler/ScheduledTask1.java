package com.poc.poc.scheduler;

import com.poc.poc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
@Component
public class ScheduledTask1 {

    @Autowired
    private TransactionService transactionService;

    @Scheduled(cron = "10 58 14 * 3 *")
    public void taskScheduling1(){

        System.out.println("Hello World........Entries............."+new Date());
       // transactionService.getTransactionForDateOfPurchage(LocalDate.of(2020, Month.FEBRUARY,20));
        transactionService.getTransactionForDateOfPurchage(LocalDate.now());
    }
}
