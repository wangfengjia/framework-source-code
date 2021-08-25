package com.dubbo.www.consumer;

import com.dubbo.www.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/consumer.xml");
        context.start();

        IUserService userService = context.getBean("userService", IUserService.class);
        String hello = userService.hello();
        System.out.println(hello);

    }
}
