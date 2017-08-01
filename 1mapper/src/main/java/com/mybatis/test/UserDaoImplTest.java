package com.mybatis.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.entity.User;
import com.mybatis.service.UserService;

public class UserDaoImplTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		// 创建spring容器

		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

	}

	@Test
	public void testFindUserById() throws Exception {

		// 从spring容器中获取UserDao这个bean
		UserService service = applicationContext.getBean("userService",
				UserService.class);
		User user = service.findUserById(1);
		System.out.println(user);

	}

	@Test
	public void deleteUser() throws Exception {

	}

	@Test
	public void insertUser() throws Exception {

	}

	@Test
	public void updateUser() throws Exception {

		// 从spring容器中获取UserDao这个bean
		UserService service = applicationContext.getBean("userService",
				UserService.class);
		User user = new User();
		user.setId(46);
		user.setUsername("hehe22");
		user.setSex("2");
		service.updateUser(user);

	}

}