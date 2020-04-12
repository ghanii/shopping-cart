package com.poc.poc.scheduler;

import com.poc.rtb.poc.service.FinalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class UpgradeDowngradeCustomer {

    @Autowired
    private FinalTransactionService finalTransactionService;
    private static int year =2020;

    @Scheduled(cron = "00 59 11 31 12 *")
    public void upgradeDowngradeCustomer(){

        finalTransactionService.upgradeDowngradeCustomerLevel(LocalDate.of(year,Month.JANUARY,1),LocalDate.of(year,Month.DECEMBER,31));
        year=year++;

    }
}
