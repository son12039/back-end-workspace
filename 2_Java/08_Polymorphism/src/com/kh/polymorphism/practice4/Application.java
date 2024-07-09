package com.kh.polymorphism.practice4;

import java.util.Scanner;

import com.kh.polymorphism.practice4.controller.Controller;
import com.kh.polymorphism.practice4.model.Book;
import com.kh.polymorphism.practice4.model.Customer;

public class Application {
    private Book[] books = new Book[4];
    private Scanner sc = new Scanner(System.in);
    private Customer cm = new Customer();
    private Controller con = new Controller();
    private int[] arr = new int[4];

    public static void main(String[] args) {
        Application app = new Application();
        
        // 도서 초기화 메서드 호출
        app.bookmenu();
        
        app.firstmenu();
        app.menu();
    }

    public void firstmenu() {
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("나이 : ");
        int age = Integer.parseInt(sc.nextLine());
        Customer c = new Customer(name, age);
        con.firstmenu(name, age);
    }

    public void menu() {
        boolean check = true;
        while (check) {
            System.out.println("==== 메뉴 ====");
            System.out.println("1. 마이페이지");
            System.out.println("2. 도서 대여하기");
            System.out.println("3. 프로그램 종료하기");
            System.out.print("메뉴 번호 : ");
            int menuNum = Integer.parseInt(sc.nextLine());
            
            switch (menuNum) {
                case 1:
                    System.out.println(cm.toString());
                    break;
                case 2:
                    System.out.println("도서 대여하기");
                    bookmenueach();
                    
                    System.out.print("대여할 도서 번호 선택: ");
                    int bookNum = Integer.parseInt(sc.nextLine());
            
                    int index = bookNum - 1;
                    
                    if (index < 0 || index >= books.length) {
                        System.out.println("잘못된 도서 번호입니다.");
                    } else {
                        if (arr[index] != 0) {
                            System.out.println("이미 대여한 책입니다.");
                        } else {
                            System.out.println("성공적으로 대여되었습니다.");
                        }
                    }
                    break;
                case 3:
                    check = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호입니다.");
                    break;
            }
        }
    }

    public void bookmenu() {
        books[0] = new Book("밥을 지어요", true, 1);
        books[1] = new Book("오늘은 아무래도 덮밥", false, 2);
        books[2] = new Book("원피스", false, 3);
        books[3] = new Book("귀멸의 칼날 23", false, 4);
        
    }

    public void bookmenueach() {
        System.out.println("도서 목록:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i+1)+ "번 도서 : "+books[i]);
        }
    }
}

