package com.yihaomen.web.index;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.entity.User;
import com.mybatis.service.UserService;

@Controller
public class Index {
	@Resource
	private UserService userService;

    @RequestMapping("/")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //输出字符串
        response.getWriter().append("hello world");
    }
    
    @RequestMapping("/insertUser")
    public void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();  
        user.setId(22);  
        user.setUsername("hehe22");
        user.setBirthday("2");
        int r = userService.insertUser(user);
               
        System.out.printf("result:%d userid: %d\n", r, user.getId());
        response.getWriter().append("userid:" + (user.getId()));
    }
    
    @RequestMapping("/deleteUser")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int r = userService.deleteUser(2);
        
        System.out.println(r);
        
        response.getWriter().append("user");
    }
    
    @RequestMapping("/findUserById")
    public void findUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	User user = userService.findUserById(1);
        System.out.println(user); 
        
        response.getWriter().append("user");
    }
    
    @RequestMapping("/findUserByUsername")
    public void findUserByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	List<User> users = userService.findUserByUsername("2");
        System.out.println(users);
        
        response.getWriter().append("user");
    }
    
    @RequestMapping("/updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();  
        user.setId(22);  
        user.setUsername("hehe22");
        user.setBirthday("2");
        int r = userService.updateUser(user);
        
        System.out.println(r);
        
        response.getWriter().append("user");
    }
}