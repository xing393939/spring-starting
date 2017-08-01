package com.yihaomen.web.index;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.entity.User;
import com.mybatis.service.UserService;

@Controller
public class Index {
	@Resource
	private UserService userService;

    @RequestMapping("/hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //输出字符串
        response.getWriter().append("hello world");
    }
    
    @RequestMapping("/list")
    public void listall(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
    	User user = userService.findUserById(1);
        System.out.println(user); 
        
        response.getWriter().append("user");
    }
}