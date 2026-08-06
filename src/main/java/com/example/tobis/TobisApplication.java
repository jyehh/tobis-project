package com.example.tobis;

import com.example.tobis.dao.UserDao;
import com.example.tobis.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class TobisApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		SpringApplication.run(TobisApplication.class, args);

		UserDao dao = new UserDao();

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
