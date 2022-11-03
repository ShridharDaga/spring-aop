package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
@Order(2)
public class DemoLogging {

    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        log.info("\n=====>>> Executing @Around advice on method : " + method + "\n");

        // get begin timestamp
        long begin = System.currentTimeMillis();

        Object result = null;

        try{
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception e){
            log.warn("\n=====>>> Exception is : " + e + "\n");
            throw e;
        }

        // end timestamp
        long end = System.currentTimeMillis();
        log.info("\n=====>>> Executing Duration : " + (end - begin) / 1000.0 + " seconds\n");

        return result;
    }


    @After("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        log.info("\n=====>>> Executing @After (Finally) advice on method : " + method + "\n");
    }



    // add new advice for @AfterThrowing on the findAccounts method
    @AfterThrowing(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        log.info("\n=====>>> Executing @AfterThrowing advice on method : " + method + "\n");

        // print out the exception
        log.warn("\n=====>>> Exception is : " + exception + "\n");

    }

    // add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
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
