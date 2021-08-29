package com.spring.www.dao.impl;

import com.spring.www.dao.UserMapper;
import com.spring.www.domain.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User getById(Integer id) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getById(id);
    }

    @Override
    public int insert(User user) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.insert(user);
    }

    @Override
    public int update(User user, Integer id) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int batchDelete(List<Integer> ids) {
        return 0;
    }
}
