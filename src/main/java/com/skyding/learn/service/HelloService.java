package com.skyding.learn.service;

import com.skyding.learn.controller.HelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * created at 2018/10/29
 *
 * @author weichunhe
 */
@Service
public class HelloService {

    public int getAge(String name) {
        if (StringUtils.isEmpty(name)) {
            return 0;
        }
        return name.length();
    }
}
