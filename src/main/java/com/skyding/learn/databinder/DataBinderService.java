package com.skyding.learn.databinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

import javax.annotation.PostConstruct;

/**
 * @author weichunhe
 * created at 2019/11/1
 */
@Service
public class DataBinderService {

    @Autowired
    private DataBinder dataBinder;

    @PostConstruct
    public void test() {
        System.out.println(dataBinder.getValidators());
    }
}
