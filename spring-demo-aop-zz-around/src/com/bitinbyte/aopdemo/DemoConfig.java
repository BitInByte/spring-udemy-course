package com.bitinbyte.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * DemoConfig
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.bitinbyte.aopdemo")
public class DemoConfig {

}
