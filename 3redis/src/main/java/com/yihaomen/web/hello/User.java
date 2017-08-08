package com.yihaomen.web.hello;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long id;

    /** 用户名 */
    private String name;

    /** 用户年龄 */
    private Integer age;

	public User(Long i, String string2) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.name = string2;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}