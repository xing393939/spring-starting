package com.mybatis.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.dao.IUserDao;
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
		IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user);

	}

	@Test
	public void deleteUser() throws Exception {

		// 从spring容器中获取UserDao这个bean
		IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
		userDao.deleteUser(44);

	}

	@Test
	public void insertUser() throws Exception {

		// 从spring容器中获取UserDao这个bean
		IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
		User user = new User();
		user.setUsername("hehe");
		user.setSex("2");
		userDao.insertUser(user);
		System.out.println(user);
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