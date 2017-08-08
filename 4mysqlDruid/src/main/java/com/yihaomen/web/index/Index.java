package com.yihaomen.web.index;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Charsets;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Maps;
import com.google.common.collect.Iterables;

//com.google.common.primitices包下的Ints，Doubles，Floats，Shorts，Bytes以及Bools等工具类
import com.google.common.primitives.Ints;

import com.google.common.io.Files;

import com.mybatis.entity.User;
import com.mybatis.service.UserService;

@Controller
public class Index {
	@Resource
	private UserService userService;
	
    @RequestMapping("/")
    public String index(Model model) {
    	return "index";
    }
    
    @RequestMapping("guava")
    public String guava(Model model) {
    	//lists
    	List<Integer> aa = Lists.newArrayList(1, 2, 3);
    	List<String> bb = Lists.newArrayList("1", "2", "3");
    	List<User> uu = Lists.newArrayList(new User(), new User());
    	bb.add("1");
    	System.out.println(bb);
    	
    	//list to array
    	Integer[] a = Iterables.toArray(aa, Integer.class);
    	String[] b = Iterables.toArray(bb, String.class);
    	int[] c = Ints.toArray(aa);
    	System.out.println("" + a[0] + a[1] + a[2] + "");
    	System.out.println("" + c[0] + c[1] + c[2] + "");
    	System.out.println(b);
    	
    	//sets
    	HashSet<User> su = Sets.newHashSet();
    	HashSet<String> s1 = Sets.newHashSet("a", "b", "c");
    	su.addAll(uu);
    	System.out.println(s1);
    	
    	//maps
    	HashMap<String, User> hm = Maps.newHashMap();
    	hm.put("key", uu.get(0));
    	System.out.println(hm);
    	
    	//files
    	//File file2 = new File(getClass().getResource("/demo.txt").getFile());
    	File file = new File("./demo.txt");
    	System.out.println(file.getAbsolutePath());
    	List<String> lines = null;
    	try {
    		lines = Files.readLines(file, Charsets.UTF_8);
    		System.out.println(lines);
    	} catch (IOException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return "index";
    }

    @RequestMapping("array2list2set2map")
    public String array2list2set2map(Model model) {
        //array
    	int[] a = {5,2,3,4};
        String[] b = {"1","2","3"};
        User[] users = {new User(), new User()};
        Arrays.sort(a);
        System.out.print("" + a[0] + a[1] + a[2] + "");
        
        //list
        //Arrays.asList(b) is an array whose size can't change
        List<String> immobilizedSize = Arrays.asList(b);
        List<String> bb = new ArrayList<String> (immobilizedSize);
        List<User> uu = Arrays.asList(users);
        bb.add("1");
        System.out.print(bb);
        
        //set
        HashSet<User> su = new HashSet<User>();
        HashSet<String> s1 = new HashSet<String>();
        su.addAll(uu);
        s1.addAll(bb);
        s1.add("1");
        System.out.print(s1);
        
        //map
        HashMap<String, User> hm = new HashMap<String, User>();
        hm.put("key", uu.get(0));
        System.out.print(hm);
    	
        return "index";
    }
    
    @RequestMapping("/insertUser")
    public String insertUser(ModelMap model) {
        User user = new User();  
        user.setId(22);  
        user.setUsername("hehe22");
        user.setBirthday("2");
        userService.insertUser(user);
        
        ArrayList<User> articles = new ArrayList<User>();
        articles.add(user);
               
        model.addAttribute("userid",  user.getId());
        model.addAttribute("user", user);
        model.addAttribute("articles", articles);
        return "insertUsers";
    }
    
    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser() {
        int r = userService.deleteUserById(3);
        User user = new User();  
        user.setId(22);  
        user.setUsername("hehe22");
        user.setBirthday("2");
        
        ArrayList<User> articles = new ArrayList<User>();
        articles.add(user);
        
        ModelAndView mav = new ModelAndView("deleteUser");
        mav.addObject("userid",  r);
        mav.addObject("user", user);
        mav.addObject("articles", articles);
        
        return mav;
    }
    
    @RequestMapping("/findUserById")
    public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
    	User user = userService.findUserById(1);
        System.out.println(user);
        
        response.getWriter().append("user");
        
        ModelAndView mav = new ModelAndView("hello2");
        
        return mav;
    }
    
    @RequestMapping("/findUserByUsername")
    public void findUserByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	List<User> users = userService.findUserByUsername("2");
        System.out.println(users);
        
        response.getWriter().append("user");
    }
    
    @RequestMapping("/updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();  
        user.setId(1);  
        user.setUsername("abc");
        user.setBirthday("2");
        int r = userService.updateUser(user);
        
        System.out.println(r);
        
        response.getWriter().append("result:" + r);
    }
}