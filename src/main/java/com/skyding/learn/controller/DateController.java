package com.skyding.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * created at 2018/10/30
 *
 * @author weichunhe
 */
@RestController
@RequestMapping("/today")
public class DateController {
    @RequestMapping("/now")
    public Map now(Date now) {
        Map map = new HashMap();
        map.put("now", now);
        return map;
    }
}
