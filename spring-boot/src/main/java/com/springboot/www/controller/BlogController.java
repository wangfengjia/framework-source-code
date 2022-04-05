package com.springboot.www.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/blog")
public class BlogController {

    @GetMapping("/hello/{id}")
    @ResponseBody
    public String hello(@PathVariable("id") Integer id){
        System.out.print("request hello");
        return "hello, world, " + id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(){

        return "create success";
    }



}
