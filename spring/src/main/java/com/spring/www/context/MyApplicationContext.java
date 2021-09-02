package com.spring.www.context;

import com.spring.www.dao.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-transaction-v2.xml"});
//
//        User user1 = context.getBean("user1", User.class);
//        System.out.println(user1.getName());
//
        UserMapper userMapper = context.getBean("userDaoTrans", UserMapper.class);
        userMapper.getById(1);
        System.out.println("test aop");

//        UserMapper userDao = context.getBean("userDaoTrans", UserMapper.class);
//
//        userDao.getById(1);
    }
}
