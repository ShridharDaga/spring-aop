package com.example.aopdemo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MembershipDAO {
    public boolean addSillyMember(){
        log.info("DOING STUFF: ADDING A MEMBERSHIP ACCOUNT\n");
        return true;
    }

    public void goToSleep(){
        log.info("going to sleep...\n");
    }
}
