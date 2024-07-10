package com.kh.practice;

import java.util.Scanner;

import com.kh.practice.controller.MemberControllerteacher;
import com.kh.practice.exception.DuplicateNameException;
import com.kh.practice.exception.RecordNotFoundException;
import com.kh.practice.model.Memberteacher;

public class Applicationteacher {
	
	private Scanner sc = new Scanner(System.in);
	private MemberControllerteacher mc = new MemberControllerteacher();

	public static void main(String[] args) {
		Applicationteacher app = new Applicationteacher();
		app.mainMenu();
	}
	
	
	public int mainMenu() {
		boolean check = true;
		while(true) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.println("현재등록된 회원수는 " + mc.count + "명입니다");
			
			if(mc.count< 3) {
				System.out.println("1. 새 회원 등록");
			} else {
				System.out.println("회원수가 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			
			try {
				int select =  Integer.parseInt(sc.nextLine());
				switch(select) {
				case 1: insertMember();break;
				case 2: updateMember();break;
				case 3: printAll();break;
				case 9: System.out.println("프로그램종료");  check = false; break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");			
				}
			} catch (Exception e) {
				System.out.println("정수만 입력!");
			}
			
			
			
		}
	}
		public void insertMember() {
			System.out.print("아이디 :");
			String id = sc.nextLine();
			
			try {
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("비밀번호 : ");
				String pwd = sc.nextLine();
				System.out.print("이메일 : ");
				String email = sc.nextLine();
				System.out.print("성별(M/F) : ");
				char gender = sc.nextLine().charAt(0);
				System.out.print("나이 : ");
				int age = Integer.parseInt(sc.nextLine());
				
				Memberteacher m = new Memberteacher(id, name, pwd, email, gender, age);
				mc.insertMember(m);
				if(mc.checkId(id) != -1) {
				} else {
					}
				} catch (DuplicateNameException e) {
					//e.printStackTrace();
					System.out.println(e.getMessage());
					insertMember();
			}	
		}
		
		public void updateMember() {
			System.out.println("수정할 회원의 아이디 : ");
			String id = sc.nextLine();
			
			try {
				if(mc.checkId(id) == -1) {
					System.out.println("회원 정보가 없습니다");
					return;
				}
				System.out.println("수정할 이름 : ");
				String name = sc.nextLine();
				System.out.println("수정할 이메일 : ");
				String email = sc.nextLine();
				System.out.println("수정할 비밀번호 : ");
				String pwd = sc.nextLine();
				mc.updateMember(id, name, email, pwd);
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}
			
			
		}
		
		public void printAll() {
			Memberteacher[] mArr = mc.printAll();
			for(Memberteacher m : mArr) {
				if(m!=null)System.out.println(m);
			}
		}
}