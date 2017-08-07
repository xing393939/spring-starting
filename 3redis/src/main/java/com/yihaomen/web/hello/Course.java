package com.yihaomen.web.hello;

import java.io.Serializable;

public class Course implements Serializable {
	public Course(int i, String string) {
		this.id = i;
		this.name = string;
	}
	public int id;
	public String name;
	
}
