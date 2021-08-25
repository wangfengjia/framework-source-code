package com.dubbo.www.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class Provider {

    public static void main(String[] args) throws Exception {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/provider.xml");
        context.start();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
