package com.yihaomen.web.hello;

import java.util.HashSet;

public class Student implements Comparable<Student> {
	
	public String id;
	public String name;
	public HashSet<Course> courses;
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}
	
}
