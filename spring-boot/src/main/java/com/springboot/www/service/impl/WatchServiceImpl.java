package com.springboot.www.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.www.domain.Watch;
import com.springboot.www.mapper.WatchMapper;
import com.springboot.www.service.IWatchService;
import org.springframework.stereotype.Service;

@Service
public class WatchServiceImpl extends ServiceImpl<WatchMapper, Watch> implements IWatchService {
}
