package com.springboot.www.controller;

import com.springboot.www.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @PostMapping("/create")
    public String create(@RequestBody User user){
        return user.getName();
    }


    @GetMapping("/get")
    public User get(){

        User user = new User();
        user.setId(1);
        user.setName("wangyongchun");
        user.setPassword("duoduo");

        return user;
    }
}
