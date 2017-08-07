package com.yihaomen.web.hello;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Helloworld {

    @Autowired
    private RedisTemplate<String,User> redisTemplate;
    
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("hello world");
    }
	
    @RequestMapping("/redis")
    public void Serialized(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("<html>");

    	User u1=new User();
        u1.setId(1L);
        u1.setName("wang");
        u1.setAge(22);
        
        redisTemplate.opsForValue().set("user:wang",u1);

        User u2=redisTemplate.opsForValue().get("user:wang");
    	
        response.getWriter().println(u2);
    	
    	response.getWriter().println("</html>");
    }
	
}