package com.springboot.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@SpringBootApplication
@MapperScan("com.springboot.www.mapper")
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);


//        WatchMapper bean = context.getBean(WatchMapper.class);
//        System.out.println(bean);
//        User user01 = context.getBean("userO1", User.class);
//        System.out.println(user01);
//
//        WebConfiguration webConfiguration = context.getBean(WebConfiguration.class);
//        System.out.println(webConfiguration);


        RedisConnectionFactory bean = context.getBean(JedisConnectionFactory.class);
        System.out.println(bean);
    }
}
