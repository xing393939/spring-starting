package com.yihaomen.web.hello;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Helloworld {

    @RequestMapping("/helloworld")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("hello world 123");
    }
}