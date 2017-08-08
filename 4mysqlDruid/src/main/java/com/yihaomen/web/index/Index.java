package com.yihaomen.web.index;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.mybatis.entity.User;
import com.mybatis.service.UserService;

@Controller
public class Index {
	@Resource
	private UserService userService;

    @RequestMapping("/")
    public String helloWorld(Model model) {
        return "index";
    }
    
    @RequestMapping("/insertUser")
    public String insertUser(ModelMap model) {
        User user = new User();  
        user.setId(22);  
        user.setUsername("hehe22");
        user.setBirthday("2");
        int r = userService.insertUser(user);
        
        HashMap<String, Object> a;
        ArrayList<User> articles = new ArrayList<User>();
        articles.add(user);
               
        model.addAttribute("userid",  user.getId());
        model.addAttribute("user", user);
        model.addAttribute("articles", articles);
        return "insertUsers";
    }
    
    @RequestMapping("/deleteUser")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int r = userService.deleteUserById(3);
        
        System.out.println(r);
        
        response.getWriter().append("result:" + r);
    }
    
    @RequestMapping("/findUserById")
    public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
    	User user = userService.findUserById(1);
        System.out.println(user);
        
        response.getWriter().append("user");
        
        ModelAndView mav = new ModelAndView("hello2");
        
        return mav;
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
        user.setId(1);  
        user.setUsername("abc");
        user.setBirthday("2");
        int r = userService.updateUser(user);
        
        System.out.println(r);
        
        response.getWriter().append("result:" + r);
    }
}