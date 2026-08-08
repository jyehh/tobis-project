package com.example.tobis.dao;

import com.example.tobis.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoTest {

    private final SimpleConnectorMaker simpleConnectorMaker;

    public UserDaoTest(){
        simpleConnectorMaker = new SimpleConnectorMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException{
        Connection c = simpleConnectorMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id,name,password) values(?,?,?)"
        );
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection c = simpleConnectorMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?"
        );
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;

    }
//
//    private Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/tobis","dana","123!@#");
//
//        return c;
//    }
public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		SpringApplication.run(TobisApplication.class, args);

    UserDaoTest dao = new UserDaoTest();

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
