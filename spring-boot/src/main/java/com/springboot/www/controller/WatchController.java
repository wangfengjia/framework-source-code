package com.springboot.www.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.www.domain.Watch;
import com.springboot.www.service.IWatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/watch")
public class WatchController {

    @Autowired
    private IWatchService watchService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/getById")
    public Page<Watch> getById(@RequestParam("id") Integer id){

        QueryWrapper<Watch> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "apple");

        Page<Watch> watchPage = new Page<>();
        Page<Watch> page = watchService.page(watchPage, queryWrapper);

        return page;
//        List<Watch> records = page.getRecords();

//        return records;

//        return watchService.getById(id);
    }


}
