package com.skyding.learn.service;

import com.skyding.learn.controller.HelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * created at 2018/10/29
 *
 * @author weichunhe
 */
@Service
public class HelloService {

    private String name;
    private ApplicationContext applicationContext;

    public HelloService() {
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    public HelloService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge(String name) {
        if (StringUtils.isEmpty(name)) {
            return 0;
        }
        return name.length();
    }
}
