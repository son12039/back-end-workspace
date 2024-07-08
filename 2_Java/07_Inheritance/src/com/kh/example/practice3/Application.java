package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.partice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	private EmployeeController employeeController;
	
	public Application() {
        employeeController = new EmployeeController();
	} //null일때 호출하면 오류나는거 방지용
	
	public static void main(String[] args) {

		Application application = new Application();
		int menuNum = application.employeeMenu();
		while(menuNum != 9) {
			switch (menuNum) {
				case 1 : application.insertEmp(); break; // 추가
				case 2 : application.updateEmp(); break; // 수정
				case 3 : application.printEmp(); break; // 출력
			} // switch 끝
			menuNum = application.employeeMenu(); // 메뉴 다시 출력
		} //while문 끝
		System.out.println("프로그램을 종료합니다.");
	} // 메인static끝
	
	public int employeeMenu()  { //추가메뉴
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		return sc.nextInt();	 // 메뉴선택번호 리턴하는 친구	
	}
	
	public void insertEmp(){ // 추가
		System.out.print("사원 번호 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		
		System.out.print("사원 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("사원 성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("전화 번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		String menuAdd = sc.nextLine();		
		if (menuAdd.equals("y")) {
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();	
			
			System.out.print("사원 연봉 : ");
			int salary = Integer.parseInt(sc.nextLine());
			
			System.out.print("보너스 율 : ");
			double bonus = Double.parseDouble(sc.nextLine());
		    employeeController.add(empNo, name, gender, phone, dept, salary, bonus);
		} else if (menuAdd.equals("n")) {
			System.out.println("정보 입력을 종료합니다.");
			employeeController.add(empNo, name, gender, phone);
		} else {
			System.out.println("입력오류로 메뉴로 돌아갑니다.");
			employeeController.add(empNo, name, gender, phone);
		}
	}

	public void updateEmp() { // 수정
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		switch (menuNum) {
			case 1 : System.out.print("전화 번호 입력 : ");
					String phone = sc.nextLine();
					employeeController.modify(phone);
					break;
			case 2 : System.out.print("사원 연봉 입력 : ");
					int salary = Integer.parseInt(sc.nextLine());
					employeeController.modify(salary);
					break;
			case 3 : System.out.print("보너스 율 입력 : ");
					double bonus = Double.parseDouble(sc.nextLine());
					employeeController.modify(bonus);
					break;
			case 9 : System.out.println("돌아가기");
					break;
			default: System.out.println("잘못 입력하여 처음으로 돌아갑니다.");
					break;
		}
	}
	
	public void printEmp() { // 출력
		Employee viewEmployee = employeeController.info(); 
		System.out.println(viewEmployee);
	}
}
