package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag){
        log.info("DOING MY DB WORK: ADDING MY ACCOUNT\n");
    }

    public boolean doWork(){
        log.info("DO WORK\n");
        return false;
    }
}
