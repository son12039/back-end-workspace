package com.kh.practice999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.kh.practice999.controller.Controller;
import com.kh.practice999.model.Music;

public class Application {
	static Controller con = new Controller();
	static Scanner sc = new Scanner(System.in);
	static Application app = new Application();
	static ArrayList<ArrayList<String>> musiclist= new ArrayList();
	public static void main(String[] args) {
		System.out.println(musiclist);
	boolean check = true;
	while(check) {
		int menunum = app.mainmenu();
		switch (menunum) {
	case 1 : app.lastadd();break;
	case 2 : app.firstadd();break;
	case 3 : app.Allprint();break;
	case 4 : app.search();break;
	case 5 : app.delete();break;
	case 6 : app.rewrite();break;
	case 7 : app.singerset();break;
	case 9 : System.out.println("종료");check = false;
			}
		}
	}
	
	
	
	public int mainmenu() {System.out.println("===== 메인 메뉴 =====\n"+ "1. 마지막 위치에 곡 추가\r\n"
			+ "2. 첫 위치에 곡 추가\r\n"+ "3. 전체 곡 목록 출력\r\n"
			+ "4. 특정 곡 검색\r\n"+ "5. 특정 곡 삭제\r\n"
			+ "6. 특정 곡 수정\r\n"+ "7. 가수 명 내림차순 정렬\r\n"
			+ "9. 종료");
			System.out.print("메뉴 번호 입력:");
		
			return Integer.parseInt(sc.nextLine());
	}
	public void lastadd() {
		ArrayList<String> music= new ArrayList();
		System.out.print("곡 명:");music.add(sc.nextLine());
		System.out.print("가수 명:");music.add(sc.nextLine());
		musiclist.addLast(music);
	}	
	
	public void firstadd() {
		ArrayList<String> music= new ArrayList();
		System.out.print("곡 명:");music.add(sc.nextLine());
		System.out.print("가수 명:");music.add(sc.nextLine());
		musiclist.addFirst(music);
	}
	public void Allprint() {
		System.out.println("***** 전체 곡 목록 출력 *****");
		System.out.println(con.print());
		for(int i = 0; i<musiclist.size(); i++) {
			System.out.println(musiclist.get(i).get(1)+ "-"+musiclist.get(i).get(0));
		}
	}
	public void search() {
		System.out.println("***** 특정 곡 검색 *****");
		String search = sc.nextLine();
		for(int i = 0; i<musiclist.size()+1; i++) {
			if(i ==musiclist.size()) {System.out.println("없는 노래입니다");break;}
			if(musiclist.get(i).get(0).equals(search)) {
				System.out.println(musiclist.get(i).get(1)+ "-" +
			musiclist.get(i).get(0)+"을 검색했습니다.");break;
			}
		}

	}
	public void delete() {
		System.out.println("***** 특정 곡 삭제 *****");
		System.out.print("삭제할 곡 명:");
		String delete = sc.nextLine();
		for(int i = 0; i<musiclist.size()+1; i++) {
			if(i ==musiclist.size()) {System.out.println("삭제할 곡이 없습니다");break;}
			if(musiclist.get(i).get(0).equals(delete)) {
				System.out.println(musiclist.get(i).get(1)+ "-" +
			musiclist.get(i).get(0)+"을 삭제했습니다.");
				musiclist.remove(i);break;
			}
		}
		
	}
	public void rewrite() {
		ArrayList<String> music= new ArrayList();
		System.out.print("검색할 곡 명:");
		String rewrite = sc.nextLine();
		for(int i = 0; i<musiclist.size()+1; i++) {
			if(i ==musiclist.size()) {System.out.println("수정할 곡을 찾지 못했습니다");break;}
			if(musiclist.get(i).get(0).equals(rewrite)) {
				System.out.print("수정할 곡 명:");music.add(sc.nextLine());
				System.out.print("수정할 가수 명:");music.add(sc.nextLine());
				System.out.println(musiclist.get(i).get(1)+ "-" +
						musiclist.get(i).get(0)+"의 값이 변경되었습니다.");
				musiclist.remove(i);
				musiclist.add(i,music);			
				break;
			}
		}
	}
	public void singerset() {


		 System.out.println("***** 노래 제목 내림차순 정렬 *****");
		    for (ArrayList<String> playlist : musiclist) {
		        System.out.println(playlist.get(1) + " - " + playlist.get(0));
		    }
	}
	
	
	
}