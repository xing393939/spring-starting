package com.yihaomen.web.index;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String Index(Model model) {
       return "index";
   }
	
   @RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
   
   @RequestMapping(value = "/hello2", method = RequestMethod.GET)
   public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.getWriter().append("hello world");
   }
   
   @RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("student", "command", new Student());
   }
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("SpringWeb")Student student, ModelMap model) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());      
      return "result";
   }
   
   @RequestMapping(value = "/redirect", method = RequestMethod.GET)
   public String redirect() {
      return "redirect:finalPage";
   }
   
   @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
   public String finalPage() {
      return "final";
   }
}

