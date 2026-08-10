package com.example.tobis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao{

    public NUserDao(ConnectionMaker connectionMaker) {
        super(connectionMaker);
    }
//
//    @Override
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//
//        Class.forName("org.postgresql.Driver");
//        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/tobis", "dana", "123!@#");
//
//        return c;
//
//    }
}
