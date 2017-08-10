package com.yihaomen.web.hello;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Controller
public class Helloworld {  
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView fooView() {
    	ModelAndView view = new ModelAndView("index");
      
      	view.addObject("name", "foo");
      	return view;
    }
}