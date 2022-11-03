package com.example.aopdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class TrafficFortuneService {

    public String getFortune(){
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e) {
            log.info(e + "\n");
        }

        return "Expect heavy traffic...";
    }
}
