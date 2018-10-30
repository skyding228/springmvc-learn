package com.skyding.learn.service;

import org.springframework.context.annotation.Bean;

/**
 * created at 2018/10/30
 *
 * @author weichunhe
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean("helloService")
    public HelloService s1() {
        System.out.println("s1 -------------");
        return new HelloService("1");
    }

    @Bean("helloService")
    public HelloService s2() {
        System.out.println("s2 -------------");
        return new HelloService("2");
    }


}
