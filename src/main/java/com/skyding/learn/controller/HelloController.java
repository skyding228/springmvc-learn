package com.skyding.learn.controller;

import com.skyding.learn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * created at 2018/10/29
 *
 * @author weichunhe
 */
@RestController
@RequestMapping("/")
public class HelloController {

    private ApplicationContext applicationContext;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

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

    @RequestMapping("/now")
    public Map now(Date now) {
        Map map = new HashMap();
        map.put("now", now);
        return map;
    }
}
