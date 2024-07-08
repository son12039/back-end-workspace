package com.kh.example.partice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController{
	private Employee employee;
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		this.employee = new Employee(empNo,name,gender,phone,dept,salary,bonus);
	}
	
	
	public void add (int empNo, String name, char gender, String phone) {
		this.employee = new Employee (empNo, name, gender, phone, null, 0, 0.0);
	}
	public void modify(String phone) {
		employee.setPhone(phone);	
	}
	public void modify(int salary) {
		employee.setSalary(salary);
	}
	public void modify(double bonus) {
		employee.setBonus(bonus);
	}
	
	
	public Employee info() {
		return employee;
	}
}
