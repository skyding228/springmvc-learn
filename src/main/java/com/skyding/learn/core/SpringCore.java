package com.skyding.learn.core;

import com.skyding.learn.core.bean.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 验证spring 核心框架
 *
 * @author weichunhe
 * created at 2019/11/7
 */
public class SpringCore {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml-bean.xml");


        System.out.println(context.getBean("userService",UserService.class).hello("wch"));
    }
}
