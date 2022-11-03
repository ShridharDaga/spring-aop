package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountDAO {

    private String name;
    private String serviceCode;
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
