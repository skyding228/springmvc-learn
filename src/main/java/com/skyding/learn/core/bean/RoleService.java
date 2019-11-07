package com.skyding.learn.core.bean;

import org.springframework.stereotype.Service;

/**
 * @author weichunhe
 * created at 2019/11/7
 */
@Service
public class RoleService {

    public boolean canAccess(String menu) {
        return true;
    }
}
