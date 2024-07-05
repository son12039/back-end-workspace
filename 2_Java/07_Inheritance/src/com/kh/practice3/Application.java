package com.kh.practice3;

import java.io.PrintStream;
import java.util.Scanner;

import com.kh.example.partice3.controller.EmployeeController;
import com.kh.practice3.model.Employee;

public class Application {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		EmployeeController employeeController = new EmployeeController();
		System.out.println(employeeController);
		Scanner sc = new Scanner(System.in);
		int empNo = 0;
		String name = "";
		char gender = '0';
		String phone = "";
		String dept = "";
		int salary = 0;
		double bonus = 0;
		int menu = 0;
		
		while(menu != 9) {
		 menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1 : {System.out.print("사원 번호 : ");
				 empNo = Integer.parseInt(sc.nextLine());
		
				System.out.print("사원 이름 : ");
				name = sc.nextLine();
				
				System.out.print("사원 성별 : ");
				gender = sc.nextLine().charAt(0);
				
				System.out.print("전화 번호 : ");
				phone = sc.nextLine();
				
				System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
				char menuadd = sc.nextLine().charAt(0);
				if (menuadd == 'y') {
					System.out.print("사원 부서 : ");
					dept = sc.nextLine();
					
					System.out.print("사원 연봉 : ");
					salary = Integer.parseInt(sc.nextLine());
					
					System.out.print("보너스 율 : ");
					bonus = Double.parseDouble(sc.nextLine());
					break;
					} else if (menuadd == 'n') {
						break;
					} else {System.out.println("잘못 입력하여 처음으로 돌아갑니다");
					break;}
				}
					
		case 2 : {System.out.println("사원의 어떤 정보를 수정하시곘습니까?");
				 if(sc.nextLine().charAt(0) == 'y') 
		 		 System.out.println("1. 전화 번호");
		 		 System.out.println("2. 사원 연봉");
		 		 System.out.println("3. 보너스 율");
		 		 System.out.println("9. 돌아가기");
		 		 System.out.print("메뉴 번호를 누르세요 : ");
		 		 int menu2 = Integer.parseInt(sc.nextLine());
		 		 	 switch (menu2) {
		 		 	case 1 : System.out.println("전화 번호 입력 : ");
		 		 			 phone = sc.nextLine();
		 		 			 break;
		 		 	case 2 : System.out.println("사원 연봉 입력 : ");
		 		 			 salary = Integer.parseInt(sc.nextLine());
		 		 			 break;
		 		 	case 3 : System.out.println("보너스 율 입력 : ");
		 		 			 bonus = Double.parseDouble(sc.nextLine());
		 		 			 break;
		 		 	case 9 : System.out.println("프로그램을 종료합니다");
		 		 	break;}
		
		 		 	 }
		case 9 : {System.out.println("프로그램을 종료합니다");break;}
		 		 } // menu문 끝
		}// while문 끝
		//System.out.printf("넘버 %d 이름 %s 성별 %s 전화번호 %s 부서 %s 월급 %d 보너스 %f",
			//	empNo,name,gender,phone,dept,salary,bonus);
	}// 클래스 메뉴
	
	public int employeeMenu() {
		int employeeMenu = Integer.parseInt(sc.nextLine());
		return employeeMenu;		
	}
	
	public void insertEmp() {
		
	}
	
	public void updateEmp() {
		
	}
	public void printEmp() {
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
	}
	
}
