package com.yihaomen.web.index;
import java.util.List;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.yihaomen.mybatis.inter.IUserOperation;
import com.yihaomen.mybatis.model.Article;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
    @Autowired
    IUserOperation userMapper;
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class); 

    @RequestMapping("/list")
    public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
        List<Article> articles=userMapper.getUserArticles(1);
        
        System.out.println(articles);
        logger.info("日志打印");
        logger.info("now {}" , "starting server");
        
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("articles",articles);
        return mav;
    }
}