package com.springboot.www.controller;

import com.springboot.www.domain.Watch;
import com.springboot.www.service.IWatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/watch")
public class WatchController {

    @Autowired
    private IWatchService watchService;

    @GetMapping("/getById")
    public Watch getById(@RequestParam("id") Integer id){

        return watchService.getById(id);
    }
}
