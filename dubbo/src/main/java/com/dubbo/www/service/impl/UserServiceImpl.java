package com.dubbo.www.service.impl;

import com.dubbo.www.service.IUserService;

public class UserServiceImpl implements IUserService {

    @Override
    public String hello() {
        return "hello, world";
    }
}
