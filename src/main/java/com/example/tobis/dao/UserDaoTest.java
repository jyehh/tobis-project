package com.example.tobis.dao;

import com.example.tobis.domain.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    //		SpringApplication.run(TobisApplication.class, args);

//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        UserDao dao = new DaoFactory().userDao();

        ApplicationContext con = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = con.getBean(UserDao.class);

        User user = new User();
        user.setId("dana");
        user.setName("박지혜");
        user.setPassword("password");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");

    }

}
