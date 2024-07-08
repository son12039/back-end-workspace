package com.kh.polymorphism.practice4;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.polymorphism.practice4.controller.Controller;
import com.kh.polymorphism.practice4.model.Customer;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	 Customer cm= new Customer();
	 Controller con = new Controller();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Application app = new Application();
		app.firstmenu();
		app.menu();
		}
	
	public void firstmenu() {
		System.out.print("이름 : ");
		String name= sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		Customer c= new Customer(name,age);
		con.firstmenu(name, age);
		
	}
	
	public void menu() {
		boolean check = true;
		while (check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1.마이페이지");
			System.out.println("2.도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 :");
			int[] arr = new int[4];
			int menunum = Integer.parseInt(sc.nextLine());
			switch (menunum) {
			case 1:
				System.out.println(cm.toString());
				break;
			case 2:
				for(int i = 0; i<=3; i++) {
					if(arr[i] == 0) {
					System.out.println(i+1+"번 도서");
					} else {
					System.out.println("대여한 책입니다");
					}
				System.out.print("대여할 도서 번호 선택:");
				int a =Integer.parseInt(sc.nextLine());
				for(int j = 1; j<=4; j++) {
					if(a==i) {
						arr[j-1] = j;
						System.out.println(Arrays.toString(arr));
					}
				}
			}break;
			case 3:
				check = false;
			}
		}
	}
	public void bookmenu() {
	}
}
