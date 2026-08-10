package com.example.tobis.dao;

import com.example.tobis.domain.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;

import java.sql.*;

public abstract class UserDao {

//    private final SimpleConnectorMaker simpleConnectorMaker;

    private ConnectionMaker connectionMaker;

    public UserDao(){
//        simpleConnectorMaker = new SimpleConnectorMaker();
        connectionMaker = new NConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException{
//        Connection c = getConnection();
//        Connection c = simpleConnectorMaker.makeNewConnection();
        Connection c = connectionMaker.makeConnection();

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
//        Connection c = simpleConnectorMaker.makeNewConnection();
//        Connection c = getConnection();

        Connection c = connectionMaker.makeConnection();

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

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException ;
//        Class.forName("org.postgresql.Driver");
//        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/tobis","dana","123!@#");
//
//        return c;



public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		SpringApplication.run(TobisApplication.class, args);

//    ConnectionMaker connectionMaker = new ConnectionMaker();
    UserDao dao = new DUserDao();

    User user = new User();
    user.setId("dana2");
    user.setName("박지혜2");
    user.setPassword("password2");

    dao.add(user);

    System.out.println(user.getId() + " 등록 성공");

    User user2 = dao.get(user.getId());
    System.out.println(user2.getName());
    System.out.println(user2.getPassword());

    System.out.println(user2.getId() + " 조회 성공");

}

}
