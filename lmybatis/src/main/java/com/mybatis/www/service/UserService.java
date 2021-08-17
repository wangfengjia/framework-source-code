package com.mybatis.www.service;

import com.mybatis.www.dao.UserMapper;
import com.mybatis.www.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class UserService {


    public static void main(String[] args) {

        SqlSession session = null;
        try {

            String configPath = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(configPath);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session = factory.openSession(true);

            UserMapper userMapper = session.getMapper(UserMapper.class);

//            User newUser = new User();
//            newUser.setName("hello");
//            newUser.setPassword("world");
//            int insertResult = userMapper.insert(newUser);
//            System.out.println("insert result affected rows:[" + insertResult + "]");

            User user = userMapper.getById(1);
            System.out.println(user.getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
