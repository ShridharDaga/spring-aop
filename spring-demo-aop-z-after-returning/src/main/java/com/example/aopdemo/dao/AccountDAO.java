package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AccountDAO {

    private String name;
    private String serviceCode;

    // add a new method: findAccounts()

    public List<Account> findAccounts(){
        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }
    public void addAccount(Account account, boolean vipFlag){
        log.info("DOING MY DB WORK: ADDING MY ACCOUNT\n");
    }

    public String getName() {
        log.info("in getName()\n");
        return name;
    }

    public void setName(String name) {
        log.info("in setName()\n");
        this.name = name;
    }

    public String getServiceCode() {
        log.info("in getServiceCode()\n");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        log.info("in setServiceCode()\n");
        this.serviceCode = serviceCode;
    }

    public boolean doWork(){
        log.info("DO WORK\n");
        return false;
    }
}
