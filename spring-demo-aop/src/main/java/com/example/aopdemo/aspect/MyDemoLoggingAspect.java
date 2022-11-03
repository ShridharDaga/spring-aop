package com.example.aopdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
@Slf4j
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with a @Before advice

    @Before("execution(* com.example.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvise(){
        log.info("\n=====>>> Executing @Before advice on method");
    }
}
