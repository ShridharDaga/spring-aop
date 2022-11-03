package com.example.aopdemo;

import com.example.aopdemo.service.TrafficFortuneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AroundHandleExceptionDemoApp {
    public static void main(String[] args) {
        // read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        log.info("---- Main Program : AroundHandleExceptionDemoApp ----");
        log.info("Calling getFortune...\n");

        boolean flag = true;
        String data = trafficFortuneService.getFortune(true);

        log.info("Fortune : " + data + "\n");

        // close the context
        context.close();
    }
}
