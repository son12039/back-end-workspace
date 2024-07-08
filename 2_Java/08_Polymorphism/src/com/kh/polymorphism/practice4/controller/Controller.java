package com.kh.polymorphism.practice4.controller;

import com.kh.polymorphism.practice4.model.Customer;

public class Controller {
	private Customer cs = new Customer();
	
	public void firstmenu(String name, int age) {
		cs.setName(name);
		cs.setAge(age);
	}
	
	public void menu() {
		cs.getName();
		cs.getAge();
	}
}
