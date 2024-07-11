package com.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.practice.model.Book;
import com.kh.practice.model.Member;



public class Application {
	
    Scanner sc = new Scanner(System.in);
    Member member = new Member();
    Book[] books = {new Book("밥을 지어요", true, 0), new Book("오늘은 아무래도 덮밥", false, 0), 
    				new Book("원피스", false, 15), new Book("귀멸의 칼날 23", false, 19)};
 
	
	public static void main(String[] args) {
		Application app = new Application();
		app.menu();
		
	}
	
	public void menu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		member.setName(name);
		member.setAge(age);
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int number = Integer.parseInt(sc.nextLine());
			
			if(number == 1) 
				System.out.println(member);
			 else if (number == 2) {
				 for(int i = 0; i<books.length; i++) 
					 System.out.println((i+1)+"번 도서:" + books[i]);
				 
				 System.out.println("대여할 도서 번호 : ");
				 int select = Integer.parseInt(sc.nextLine());
				 member.getBookList()[0] = books[select-1];
			 }
		}
	}
}

















