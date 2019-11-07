package com.skyding.learn.core.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author weichunhe
 * created at 2019/11/7
 */
@Component
@DependsOn("roleService")
public class UserService implements ApplicationContextAware {

    @Autowired
    private RoleService roleService;

    public String hello(String name) {
        return "hello " + name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
