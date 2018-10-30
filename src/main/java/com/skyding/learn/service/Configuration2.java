package com.skyding.learn.service;

import org.springframework.context.annotation.Bean;

/**
 * created at 2018/10/30
 *
 * @author weichunhe
 */
@org.springframework.context.annotation.Configuration
public class Configuration2 {

    @Bean("helloService")
    public HelloService s2() {
        System.out.println("s2 -------------");
        return new HelloService("2");
    }

}
