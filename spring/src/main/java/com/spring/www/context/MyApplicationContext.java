package com.spring.www.context;

import com.spring.www.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"component.xml"});
//
//        User user1 = context.getBean("user1", User.class);
//        System.out.println(user1.getName());
//
        IUserService userService = context.getBean("userService", IUserService.class);

        userService.create();

    }
}
