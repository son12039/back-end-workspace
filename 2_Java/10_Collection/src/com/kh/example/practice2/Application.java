package com.kh.example.practice2;

import java.util.Scanner;

public class Application {
	
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.menu();
		
	}

	public void menu() {
		boolean check = true;
		while(check) {
			System.out.println("===== 메인 메뉴 =====\n"+ "1. 마지막 위치에 곡 추가\r\n"
					+ "2. 첫 위치에 곡 추가\r\n"+ "3. 전체 곡 목록 출력\r\n"+ "4. 특정 곡 검색\r\n"
					+ "5. 특정 곡 삭제\r\n"+ "6. 특정 곡 수정\r\n"+ "7. 가수 명 내림차순 정렬\r\n"
					+ "8. 가수 명 오름차순 정렬\r\n"+"9. 종료");
			
			
		}
		
	}
	
}
