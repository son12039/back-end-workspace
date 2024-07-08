package com.kh.polymorphism;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.child.Manager;
import com.kh.polymorphism.model.child.Secretary;
import com.kh.polymorphism.model.parent.Employee;

/*
 * 다형성(Polymorphism)
 * - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
 * - 부모 타입으로 자식 객체를 생성하는 것
 * */

public class Application {
	
	private Scanner sc = new Scanner(System.in);
	

	
	public static void main(String[] args) {
		Employee e1 = new Employee("우현성", 10000);
		Employee e3 = new Engineer("이동엽", 5000, "자바", 200);
		Employee m2 = new Manager("윤유진", 7000, "개발팀");
		Employee s2 = new Secretary("송준호", 6000, "우현성");	
		Employee[] empArr = {e1, e3, m2, s2};
		
		
		Application app = new Application();
		EmployeeController control = new EmployeeController();
		Employee result = control.findEmployeeByName("이동엽", empArr);
		System.out.println(control.getAnnualSalary(result));
		System.out.println(control.getTotalSalary(empArr));
		// 다형성 + 객체 배열

	
	}
	public String findEmployeeByName() {return null;}
	public void getAnnualSalary() {
		
	}
	public void getTotalSalary() {
	}

}
