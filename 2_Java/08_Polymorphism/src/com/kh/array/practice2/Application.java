package com.kh.array.practice2;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class Application {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	String[] mArr = new String[3];
	public static void main(String[] args) {
		Application app = new Application();
		boolean check = true;
		while(check) {
			int select = app.mainMenu();
			switch(select) {
			case 1 : app.insertMember(); break;
			case 2 : app.updateMember(); break;
			case 3 : app.printAll(); break;
			case 9 : System.out.println("끝내기");check = false;break;
			}
		}
	}
	public int mainMenu() {
		System.out.println("1. 새 회원 등록");
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 전체 회원 정보 출력");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	/*
	 * 멤버 정보 추가 기능 모두!
	 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
	 * "중복된 아이디입니다. 다시 입력해주세요." 출력 후
	 * 다시 아이디 입력부터 나올 수 있게 처리
	 * 
	 * 아이디 :
	 * 이름 : 
	 * 비밀번호:
	 * 이메일 :
	 * 성별(M/F) :
	 * 나이 :
	 * */
	public void insertMember() {
		System.out.print("아이디 :");
		String id = sc.nextLine();
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
		Member member = new Member();
		}
		
	/*
	 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
	 * "회원 정보가 없습니다." 출력 후 다시 메인 화면으로
	 * 
	 * 수정할 회원의 아이디 :
	 * 수정할 이름 :
	 * 수정할 이메일 :
	 * 수정할 비밀번호 :
	 * */
	public void updateMember() {
		System.out.println("수정할 회원의 아이디 : ");
		System.out.println("수정할 이름 : ");
		System.out.println("수정할 이메일 : ");
		System.out.println("수정할 비밀번호 : ");
	}
	
	/*
	 * 전체 회원 정보 출력 (반복문 사용)
	 * */
	public void printAll() {
		mc.print();
	}
	/*
	 * 회원 수가 3명이 최대 등록 가능
	 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다."와 함께
	 * 1. 새 회원 등록 하지 못하게 화면상 보이지 않게 처리!
	 * 
	 * 최대 등록 가능한 회원 수는 3명입니다.
	 * 현재 등록된 회원 수는 ~~명입니다.
	 * 1. 새 회원 등록 -> insertMember()
	 * 2, 회원 정보 수정 -> updateMember()
	 * 3. 전체 회원 정보 출력 -> printAll()
	 * 9. 끝내기 -> 프로그램 종료
	 * 그 외 -> 잘못 입력하셨습니다. 다시 입력해주세요
	 * 
	 * 메뉴 번호 : 
	 * */
}
