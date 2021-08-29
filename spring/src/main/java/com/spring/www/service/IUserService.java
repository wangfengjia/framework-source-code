package com.spring.www.service;

import com.spring.www.domain.User;

public interface IUserService {

    /**
     * 查询
     * @param id
     * @return
     */
    User getUser(int id);

    /**
     * 创建
     * @param user
     */
    void create(User user);

    /**
     * 更新
     * @param id
     * @param newUser
     */
    void update(int id, User newUser);
}
