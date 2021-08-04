package com.bitinbyte.springdemo;

import org.springframework.stereotype.Component;

/**
 * HappyFortuneService
 */
@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }

}
