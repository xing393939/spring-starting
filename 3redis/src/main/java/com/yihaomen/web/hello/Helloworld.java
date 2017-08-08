package com.yihaomen.web.hello;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


@Controller
public class Helloworld {
	
	@Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;
    
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
    
    @RequestMapping("/gson")
    public void gson(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("<html>");

        String jsonStr = "{\"data\":[{\"typeName\":\"Themes\",\"picturePath\":\"http://ndl.mgccw.com/mu/wallpaper/2014/8/18/085628192/6ae419444f544662a831b32e60032c53.png\",\"mtypeCode\":1,\"typeCode\":44,\"appNums\":2183}],\"code\":200}";

        JsonParser parse =new JsonParser();  //创建JSON解析器
        try {
            JsonObject json=(JsonObject) parse.parse(jsonStr);  //创建jsonObject对象
            response.getWriter().println("code:"+json.get("code").getAsInt());  //将json数据转为为int型的数据
             
            JsonArray array=json.get("data").getAsJsonArray();
            for(int i = 0; i < array.size(); i ++) {
            	JsonObject subObject = array.get(i).getAsJsonObject();
            	
            	response.getWriter().println("picturePath="+subObject.get("picturePath").getAsString());
            }
             
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    	response.getWriter().println("</html>");
    }
    
    @RequestMapping("/jackson")
    public void jackson(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("<html>");

    	ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "{\"data\":[{\"typeName\":\"Themes\",\"picturePath\":\"http://ndl.mgccw.com/mu/wallpaper/2014/8/18/085628192/6ae419444f544662a831b32e60032c53.png\",\"mtypeCode\":1,\"typeCode\":44,\"appNums\":2183}],\"code\":200}";
        Map<String, Object> data = objectMapper.readValue(jsonStr, Map.class);
        List<Map<String, Object>> cats = (List<Map<String, Object>>) data.get("data");
        for (Map<String, Object> cat : cats) {
        	response.getWriter().println(cat.get("picturePath"));
        }
    	response.getWriter().println("</html>");
    }
    
    @RequestMapping("/fastjson")
    public void fastjson(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("<html>");

    	User u1=new User();
        u1.setId(1L);
        u1.setName("wang");
        u1.setAge(22);
        
        String json1 = JSON.toJSONString(u1);
        response.getWriter().println(json1);
        
        User u2 = JSON.parseObject(json1, User.class);
        response.getWriter().println(u2);
        
    	response.getWriter().println("</html>");
    }
    
    @RequestMapping("/redisService")
    public void redisService(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("<html>");

        redisService.set("key2", "value2"); 
        response.getWriter().println(redisService.get("key2"));
    	
    	response.getWriter().println("</html>");
    }
	
    @RequestMapping("/redisTemplate")
    public void redisTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
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