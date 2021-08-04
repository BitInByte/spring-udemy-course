package com.bitinbyte.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * SportConfig
 */
@Configuration
// @ComponentScan("com.bitinbyte.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // Define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // Define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

}
