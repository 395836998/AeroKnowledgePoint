package com.zhanglian2010.bean;

import java.io.Serializable;

public class ClipObj implements Serializable {

	private static final long serialVersionUID = 4364678803014674225L;

	private String name;
	
	private int age;
	
	public ClipObj(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "ClipObj {" + this.name + "," + this.age + "}";
	}
}
