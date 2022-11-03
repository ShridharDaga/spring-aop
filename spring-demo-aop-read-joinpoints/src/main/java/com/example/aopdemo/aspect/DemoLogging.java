package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
@Slf4j
@Order(2)
public class DemoLogging {

    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvise(JoinPoint theJoinPoint){
        log.info("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        // display the method args
        log.info("Method : " + methodSignature + "\n");

        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg : args){
            log.info("Arg: "+ tempArg);

            if(tempArg instanceof Account){
                Account account = (Account) tempArg;
                log.info("Account name : " + account.getName());
                log.info("Account level : " + account.getLevel());
            }
        }
    }

}
