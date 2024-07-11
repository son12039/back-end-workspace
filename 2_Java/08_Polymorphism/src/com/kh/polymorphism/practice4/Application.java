package com.kh.polymorphism.practice4;

import java.util.Scanner;

import com.kh.polymorphism.practice4.controller.Controller;
import com.kh.polymorphism.practice4.model.Book;
import com.kh.polymorphism.practice4.model.Customer;

public class Application {
    private Book[] books = new Book[4];
    private boolean[] rentedStatus = new boolean[4];
    private Scanner sc = new Scanner(System.in);
    private Customer cm = new Customer();
    private Controller con = new Controller();

    public static void main(String[] args) {
        Application app = new Application();
   
        app.bookmenu();     
        app.firstmenu();
        app.menu();
    }

    public void firstmenu() {
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("나이 : ");
        int age = Integer.parseInt(sc.nextLine());
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
                    System.out.println(con.getCustomer().toString());
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
                        if (rentedStatus[index]) {
                            System.out.println("이미 대여한 책입니다.");
                        } else {
                            Book selectedBook = books[index];
                            if (con.getCustomer().getAge() < selectedBook.getAccessAge()) {
                                System.out.println("나이 제한으로 대여 불가능입니다.");
                            } else {
                                rentedStatus[index] = true;
                                if (con.addToBookList(selectedBook)) {
                                    System.out.println("성공적으로 대여되었습니다.");
                                    if (selectedBook.isCoupon()) {
                                        con.getCustomer().setCoupon(con.getCustomer().getCoupon() + 1);
                                    }
                                } else {
                                    System.out.println("더 이상 대여할 수 없습니다.");
                                }
                            }
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
        books[0] = new Book("밥을 지어요", true, 0);
        books[1] = new Book("오늘은 아무래도 덮밥", false, 0);
        books[2] = new Book("원피스", false, 15);
        books[3] = new Book("귀멸의 칼날 23", false, 19);
    }

    public void bookmenueach() {
    //	if() {}
        System.out.println("도서 목록:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i+1) + "번 도서 : " + books[i]);
        }
    }
}










