package com.yihaomen.web.index;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

    @RequestMapping("/hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //输出字符串
        response.getWriter().append("hello world");
    }
}