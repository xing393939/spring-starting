package com.game.controller;
import java.io.File;
public class PathFile {
	private File s;
	public File getS() {
		return s;
	}
	public void setS(File s) {
		this.s = s;
	}
	
	public void haha() {
		System.out.println(s.getAbsolutePath());
		System.out.println(s.getAbsolutePath());
	}
}
