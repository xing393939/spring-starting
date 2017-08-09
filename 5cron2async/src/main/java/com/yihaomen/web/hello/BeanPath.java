package com.yihaomen.web.hello;

import java.io.IOException;
import java.io.File;

import org.springframework.core.io.ClassPathResource;

public class BeanPath {
	private ClassPathResource classPathRs;
	private File file;
	
	public ClassPathResource getS1() {
		return classPathRs;
	}
	
	public void setS1(ClassPathResource s) {
		this.classPathRs = s;
	}
	
	public File getS2() {
		return file;
	}
	public void setS2(File s) {
		this.file = s;
	}
	
	public void getFilePath() {
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsolutePath());
	}
	
	public void getClassPath () {
		try {
			System.out.println(classPathRs.getURL().toString());
		} catch (IOException e) {
			System.out.println (e.toString());
		}
		System.out.println(classPathRs.getPath());
		try {
			System.out.println(classPathRs.getFile().getAbsolutePath());
		} catch (IOException e) {
			System.out.println (e.toString());
		}
	}
}
