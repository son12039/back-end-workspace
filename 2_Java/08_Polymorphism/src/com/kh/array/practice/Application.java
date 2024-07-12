package com.kh.array.practice;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.array.practice.controller.BookController;
import com.kh.array.practice.model.Book;

public class Application {

	Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();
	ArrayList<Book> books = new ArrayList<>();

	{
		books.add(new Book("밥을 지어요", true, 0));
		books.add(new Book("밥을 지어요", true, 0));
		books.add(new Book("원피스 108", false, 15));
		books.add(new Book("귀멸의 칼날 23", false, 19));
	}

	public static void main(String[] args) {
		Application app = new Application();
		app.menu();
	}

	public void menu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("나이 : ");
		try {
			int age = Integer.parseInt(sc.nextLine());
			bc.addMember(name, age);
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력해주세요");
			menu();
		}

		boolean close = true;
		while (close) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");

			try {
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					System.out.println(bc.myPage());
					break;
				case 2:
					for (int i = 0; i < books.size(); i++) {
						System.out.println((i + 1) + "번 도서 : " + books.get(i));
					}
					System.out.print("대여할 도서 번호 선택 : ");
					int select = Integer.parseInt(sc.nextLine());

					try {
						System.out.println(bc.rentBook(books.get(select - 1)));
					} catch (IndexOutOfBoundsException e) {
						System.out.println("올바른 도서번호를 입력해주세요");
					}
					break;
				case 3:
					close = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("올바른 번호 입력");
			}
		}
	}
}

















