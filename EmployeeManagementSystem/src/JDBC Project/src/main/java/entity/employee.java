package com.entity;

public class employee {
	private int id;
	private String name;
	private int age;
	private String email;
	private int sal;
	
	public employee(int id, String name, int age, String email, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.sal = sal;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}


	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", sal=" + sal + "]";
	}
}
