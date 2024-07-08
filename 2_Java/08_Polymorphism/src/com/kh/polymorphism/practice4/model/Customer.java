package com.kh.polymorphism.practice4.model;

import java.util.Arrays;

public class Customer {
	
	private String name;
	private int age;
	private int coupon;
	private String[] bookList;
	
	public Customer() {
	}
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer(String name, int age, int coupon, String[] bookList) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
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

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public String[] getBookList() {
		return bookList;
	}

	public void setBookList(String[] bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "customer [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}
	
	
}
