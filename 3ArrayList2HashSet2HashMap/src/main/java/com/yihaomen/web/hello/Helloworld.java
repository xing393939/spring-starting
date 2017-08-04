package com.yihaomen.web.hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Helloworld {
	
    @RequestMapping("/sorttest")
    public void SortTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("<html>");
    	ArrayList<Integer> integerList = new ArrayList<Integer>();
    	Random random = new Random();
    	Integer k;
    	for (int i = 0; i < 5; i ++) {
    		do {
    			k = random.nextInt(5);
    		} while (integerList.contains(k));
    		integerList.add(k);
    	}
    	
    	//sort
    	Collections.sort(integerList);
    	
    	for (Integer t : integerList) {
    		response.getWriter().println(t + "<br />");
    	}
    	
    	ArrayList<Student> stuList = new ArrayList<Student>();
    	stuList.add(new Student("1", "aaa"));
    	stuList.add(new Student("3", "ccc"));
    	stuList.add(new Student("2", "bbb"));
    	
    	//sort student
    	Collections.sort(stuList);
    	
    	for (Student st : stuList) {
    		response.getWriter().println(st.id + st.name + "<br />");
    	}
    	
    	response.getWriter().println("</html>");
    }
	
    @RequestMapping("/maptest")
    public void MapTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("<html>");
    	HashMap<String,Student> students = new HashMap<String, Student>();
    	
    	//put
    	students.put("id2007126101", new Student("id2007126101", "Jhon"));
    	students.put("id2007126102", new Student("id2007126102", "Green"));
    	
    	//get
    	Student stu = students.get("id2007126102");
    	response.getWriter().println(stu.name + "<br />");
    	
    	//size
    	response.getWriter().println(students.size() + "<br />");
    	
    	//remove
    	students.remove("id2007126102");
    	
    	//get keys
    	Set<String> keys = students.keySet();
    	String s1 = "";
    	for (String temp : keys) {
    		s1 += temp + "<br />";
    	}
    	
    	//modify
    	students.put("id2007126101", new Student("id2007126101", "xxGreenxx"));
    	
    	//foreach
    	Set<Entry<String,Student>> entrySet = students.entrySet();
    	String s2 = "";
    	for (Entry<String,Student> entry : entrySet) {
    		s2 += entry.getKey() + entry.getValue().id + entry.getValue().name + "<br />";
    	}
    	
        response.getWriter().println(s1);
        response.getWriter().println(s2);
        response.getWriter().println("</html>");
    }

    @RequestMapping("/settest")
    public void SetTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	ArrayList<Course> coursesToSelect = new ArrayList<Course>(); //区别在于添加了泛型，在编译期间就开始检查   	
    	Course[] arr1 = {new Course(1, "aaaa"), new Course(2, "bbbb"), new Course(3, "cccc"), new Course(4, "dddd")};
    	coursesToSelect.addAll(Arrays.asList(arr1)); // 需要转变成数组的实例
    	
    	Student stu = new Student("1", "Jhon");
    	stu.courses.add(coursesToSelect.get(0));
    	String s3 = "";
    	for (Course temp3 : stu.courses) {
    		s3 += temp3.id + temp3.name + "<br />";
    	}
    	
    	//set 没有数组序号，而且set添加相同元素只会保留第一次添加的
    	
    	response.getWriter().println("<html>");
        response.getWriter().println(s3);
        response.getWriter().println("</html>");
    }
	
    @RequestMapping("/listtest")
    public void ListTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("<html>");
    	ArrayList coursesToSelect = new ArrayList();
    	ArrayList<Course> coursesToSelect2 = new ArrayList<Course>(); //区别在于添加了泛型，在编译期间就开始检查
    	coursesToSelect.add("not course type");
    	coursesToSelect.remove(0);
    	//coursesToSelect2.add("not course type");
    	for (Course c : coursesToSelect2) {} //泛型可以直接 foeeach Course

    	Course c1 = new Course(1, "aaaa");
    	coursesToSelect.add(c1);
    	
    	Course c2 = new Course(2, "bbbb");
    	coursesToSelect.add(0, c2);
    	
    	Course[] arr1 = {new Course(3, "cccc"), new Course(4, "dddd")};
    	coursesToSelect.addAll(Arrays.asList(arr1)); // 需要转变成数组的实例
    	
    	Course[] arr2 = {new Course(5, "eeee"), new Course(6, "ffff")};
    	coursesToSelect.addAll(2, Arrays.asList(arr2));
    	
    	Course temp = (Course) coursesToSelect.get(3);
    	
    	int size = coursesToSelect.size();
    	String s1 = "";
    	for (int i = 0; i < size; i ++) {
    		Course temp1 = (Course) coursesToSelect.get(i);
    		s1 += temp1.id + temp1.name + "<br />";
    	}
    	
    	//modify
    	coursesToSelect.set(0, new Course(2, "newbbbb"));
    	
    	Iterator i = coursesToSelect.iterator();
    	String s2 = "";
    	while (i.hasNext()) {
    		Course temp2 = (Course) i.next();
    		s2 += temp2.id + temp2.name + "<br />";
    	}
    	
    	//remove
    	coursesToSelect.remove(coursesToSelect.get(1));
    	coursesToSelect.remove(1);
    	Course[] arr3 = {(Course) coursesToSelect.get(1), (Course) coursesToSelect.get(2)};
    	coursesToSelect.removeAll(Arrays.asList(arr3));
    	
    	String s3 = "";
    	for (Object c : coursesToSelect) {
    		Course temp3 = (Course) c;
    		s3 += temp3.id + temp3.name + "<br />";
    	}
    	
    	//contains
    	Course c3 = (Course) coursesToSelect.get(0);
    	response.getWriter().println(coursesToSelect.contains(c3) + "<br />");
    	
        response.getWriter().println(s1);
        response.getWriter().println("<br />");
        response.getWriter().println(s2);
        response.getWriter().println("<br />");
        response.getWriter().println(s3);
        response.getWriter().println("</html>");
    }
}