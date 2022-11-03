package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        // read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call business method
        List<Account> accounts = null;
        try{
            boolean flag = false    ;
            accounts = accountDAO.findAccounts(flag);

        }
        catch (Exception ex){
            log.error("\n---Main Program: Exception Occurred : " + ex + "\n");
        }

        // display the accounts
        log.info("\n----Main Program: AfterFinallyDemoApp----");
        log.info(accounts + "\n");

        // close the context
        context.close();
    }
}
