package com.yihaomen.web.hello;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Controller
public class Helloworld {
	
	@Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;
    
    @Resource
    private ThreadPoolTaskExecutor taskExecutor;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView fooView() {
    	ModelAndView view = new ModelAndView("index");
    	List<User> todos = Arrays.asList(
			new User(1L, "Todo description aaa"),
			new User(2L, "Todo description bbb"),
			new User(3L, "Todo description ccc")
    	);
    	view.addObject("person", new User(1L, "Jo jo"));
    	view.addObject("todos", todos);
      
      	view.addObject("name", "foo");
      	return view;
    }
    
    @RequestMapping(value = "/taskExecutor", method = RequestMethod.GET)
    public void taskExecutor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("hello world");
        taskExecutor.execute(new Runnable() {
        	public void run() {
        		try {
					Thread.sleep(5000);
					System.out.println("5000s later");
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
        	}
        });
        System.out.println("my later");
    }
	
}