package com.spring.www.service.impl;

import com.spring.www.dao.UserMapper;
import com.spring.www.domain.User;
import com.spring.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUser(int id) {

        User user = userMapper.getById(id);
        return user;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(int id, User newUser) {

    }
}
