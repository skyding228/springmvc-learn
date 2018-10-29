package com.skyding.learn.controller;

import com.skyding.learn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2018/10/29
 *
 * @author weichunhe
 */
@RestController
@RequestMapping("/")
public class HelloController {

    private ApplicationContext applicationContext;

    @Autowired
    private HelloService helloService;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping("/")
    public String hello(String name) {
        return "hello " + name + ",your age is " + helloService.getAge(name);
    }
}
