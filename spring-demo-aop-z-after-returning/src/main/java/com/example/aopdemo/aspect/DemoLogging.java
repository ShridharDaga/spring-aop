package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import java.util.List;

@Aspect
@Component
@Slf4j
@Order(2)
public class DemoLogging {

    // add new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        log.info("\n=====>>> Executing @AfterReturning advice on method : " + method + "\n");

        // print out the result of the method call
        log.info("\n=====>>> Result is : " + result + "\n");

        // let's post-process the data ... let's modify it :-)
        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        log.info("\n=====>>> Updated Result is: " + result);
    }
    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }


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
