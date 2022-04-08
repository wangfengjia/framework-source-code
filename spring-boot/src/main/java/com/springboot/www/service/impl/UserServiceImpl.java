package com.springboot.www.service.impl;

import com.springboot.www.domain.User;
import com.springboot.www.mapper.UserMapper;
import com.springboot.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }
}
