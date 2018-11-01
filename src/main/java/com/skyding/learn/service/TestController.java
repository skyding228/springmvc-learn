package com.skyding.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/test")
public class TestController {

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
    public String hello(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object countAttr = session.getAttribute("count");
        Integer count = 1;
        if(countAttr instanceof Integer){
            count += (Integer) countAttr;
        }
        session.setAttribute("count",count);
        return "hello " + name + ",your age is " + helloService.getAge(name)+",has visited "+count+" times.";
    }

    @RequestMapping("/now")
    public Map now(Date now) {
        Map map = new HashMap();
        map.put("now", now);
        return map;
    }
}
