package com.game.controller;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

public class PathClasspath {
	private ClassPathResource s;
	
	public ClassPathResource getS() {
		return s;
	}
	
	public void setS(ClassPathResource s) {
		this.s = s;
	}
	
	public void haha () {
		try {
			System.out.println(s.getURL().toString());
		} catch (IOException e) {
			System.out.println (e.toString());
		}
		System.out.println(s.getPath());
		try {
			System.out.println(s.getFile().getAbsolutePath());
		} catch (IOException e) {
			System.out.println (e.toString());
		}
	}
}
