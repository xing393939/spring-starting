package com.yihaomen.web.hello;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Controller
public class Helloworld {  
    
    @RequestMapping(value = "/postjson", method = RequestMethod.POST)
    public void postjson(@RequestBody String body, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append(body);
    }
	
    @RequestMapping(value = "/postform", method = RequestMethod.POST)
    public ModelAndView postform(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        System.out.println(name);
        
        ModelAndView view = new ModelAndView("index");
        view.addObject("name", name);
        return view;
    }
    
    @RequestMapping(value = "/testcurl", method = RequestMethod.GET)
    public ModelAndView testcurl() {
    	CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost method = new HttpPost("http://localhost:8080/6form2cookie2session/postjson");
        StringEntity entity = new StringEntity("{\"a\":1}", "utf-8");  
        entity.setContentEncoding("UTF-8");  
        entity.setContentType("application/json");  
        method.setEntity(entity);
		try {
			CloseableHttpResponse result = httpClient.execute(method);
	        if (result.getStatusLine().getStatusCode() == 200) {
	        	String str = EntityUtils.toString(result.getEntity());
	        	System.out.println(str);
	        }
	        System.out.println(result.getStatusLine().getStatusCode());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ModelAndView view = new ModelAndView("index");
      	view.addObject("name", "foo");
      	return view;
    }
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView fooView() {
    	ModelAndView view = new ModelAndView("index");
      
      	view.addObject("name", "foo");
      	return view;
    }
}