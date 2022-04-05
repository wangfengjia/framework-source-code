package com.springboot.www;

import com.springboot.www.component.WebConfiguration;
import com.springboot.www.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);


        User user01 = context.getBean("userO1", User.class);
        System.out.println(user01);

        WebConfiguration webConfiguration = context.getBean(WebConfiguration.class);
        System.out.println(webConfiguration);
    }
}
