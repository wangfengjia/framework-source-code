package com.springboot.www.controller;

import com.springboot.www.domain.User;
import com.springboot.www.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public String create(@RequestBody User user){
        return user.getName();
    }

    @GetMapping("/get")
    public User get(){

        User user = userService.getById(1L);
        return user;
    }

}
