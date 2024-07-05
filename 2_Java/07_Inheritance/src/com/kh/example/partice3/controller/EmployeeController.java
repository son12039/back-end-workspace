package com.kh.example.partice3.controller;

import com.kh.practice3.model.Employee;

public class EmployeeController extends Employee{
	Employee employee = new Employee();
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		empNo = getEmpNo();
		name = getName();
		gender = getGender();
		phone = getPhone();
		dept = getDept();
		salary = getSalary();
		bonus = getBonus();
	}
	
	public void add (int empNo, String name, char gender, String phone) {
		empNo = getEmpNo();
		name = getName();
		gender = getGender();
		phone = getPhone();
	}
	public void modify(String phone) {
		phone = getPhone();
	}
	public void modify(int salary) {
		salary = getSalary();
	}
	public void modify(double bonus) {
		bonus = getBonus();
	}
	
	
}
