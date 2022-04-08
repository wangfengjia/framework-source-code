package com.springboot.www.mapper;

import com.springboot.www.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User getById(Long id);
}
