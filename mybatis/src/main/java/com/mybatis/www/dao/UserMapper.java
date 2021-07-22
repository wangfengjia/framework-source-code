package com.mybatis.www.dao;

import com.mybatis.www.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User getById(Integer id);

    int insert(User user);

    int update(@Param("user") User user, @Param("id") Integer id);

    int delete(Integer id);

    int batchDelete(@Param("list") List<Integer> ids);
}
