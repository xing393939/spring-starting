package com.zhangguo.springmvc01.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorld {
    @RequestMapping(method = RequestMethod.GET)
    public String SayHi(Model model) {
        model.addAttribute("message", "Hello 222 MVC!");
        return "sayhi";
    }
}