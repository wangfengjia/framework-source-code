package com.springboot.www.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/blog")
public class BlogController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello, world";
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(){

        return "create success";
    }
}
