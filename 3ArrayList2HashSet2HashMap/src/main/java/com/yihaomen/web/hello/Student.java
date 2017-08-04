package com.yihaomen.web.hello;

import java.util.HashSet;

public class Student {
	
	public String id;
	public String name;
	public HashSet<Course> courses;
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}
}
