package com.zhangguo.springmvc01.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Hello")
public class HelloWorld {
    @RequestMapping("/Sayhi")
    public String SayHi(Model model) {
        model.addAttribute("message", "Hello Spring MVC2!");
        return "sayhi";
    }
}