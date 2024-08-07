package com.kh.example.partice3.controller;

import com.kh.example.practice3.model.Employeeteacher;

public class EmployeeControllerteacher {
	
	private Employeeteacher employeeteacher = new Employeeteacher();
	
	// 오버로딩!!
	
	public void add(int empNo, String name, char gender, String phone) {
		employeeteacher.setEmpNo(empNo);
		employeeteacher.setName(name);
		employeeteacher.setGender(gender);
		employeeteacher.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		employeeteacher.setEmpNo(empNo);
		employeeteacher.setName(name);
		employeeteacher.setGender(gender);
		employeeteacher.setPhone(phone);
		employeeteacher.setDept(dept);
		employeeteacher.setSalary(salary);
		employeeteacher.setBonus(bonus);
	}
	
	public void modify(String phone) {
		employeeteacher.setPhone(phone);
	}
		
	public void modify(int salary) {
		employeeteacher.setSalary(salary);
	}
	
	public void modify(double bonus) {
		employeeteacher.setBonus(bonus);
	}
	
	public Employeeteacher info() {
		return employeeteacher;
	}
}
