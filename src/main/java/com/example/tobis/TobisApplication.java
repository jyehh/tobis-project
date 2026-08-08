package com.example.tobis;

import com.example.tobis.dao.UserDao;
import com.example.tobis.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class TobisApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(TobisApplication.class, args);
	}

}
