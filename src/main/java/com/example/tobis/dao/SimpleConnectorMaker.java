package com.example.tobis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 더 이상 상속을 이용한 확장 방식을 사용할 필요가 없으므로 추상 클래스로 만들 필요가 없다.
public class SimpleConnectorMaker {
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/tobis","dana","123!@#");

        return c;
    }
}
