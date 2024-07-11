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
	
	public static void main(String[] args) {
		Application app = new Application();
	boolean check = true;
	while(check) {
		
		try {	
			int menunum = app.mainmenu();
			switch (menunum) {
		case 1 : app.lastadd();break;
		case 2 : app.firstadd();break;
		case 3 : app.Allprint();break;
		case 4 : app.search();break;
		case 5 : app.delete();break;
		case 6 : app.rewrite();break;
		case 7 : app.singerdownset();break;
		case 8 : app.singerupset();break;
		case 9 : System.out.println("종료");check = false;
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");				
			}
		} catch (NumberFormatException e) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		
		}
	}
	
	public int mainmenu() {System.out.println("===== 메인 메뉴 =====\n"+ "1. 마지막 위치에 곡 추가\r\n"
			+ "2. 첫 위치에 곡 추가\r\n"+ "3. 전체 곡 목록 출력\r\n"
			+ "4. 특정 곡 검색\r\n"+ "5. 특정 곡 삭제\r\n"
			+ "6. 특정 곡 수정\r\n"+ "7. 가수 명 내림차순 정렬\r\n"
			+ "8. 가수 명 오름차순 정렬\r\n"+"9. 종료");
			System.out.print("메뉴 번호 입력:");
		
			return Integer.parseInt(sc.nextLine());
	}
	public void lastadd() {
		ArrayList<String> music= new ArrayList();
		System.out.print("곡 명:");
		String Music = sc.nextLine();
		System.out.print("가수 명:");
		String Singer = sc.nextLine();
		con.lastadd(Music, Singer);
		System.out.println("추가 성공");
	}	
	
	public void firstadd() {
		ArrayList<String> music= new ArrayList();
		System.out.print("곡 명:");
		String Music = sc.nextLine();
		System.out.print("가수 명:");
		String Singer = sc.nextLine();
		con.firstadd(Music, Singer);
		System.out.println("추가 성공");
	}
	public void Allprint() {
		System.out.println("***** 전체 곡 목록 출력 *****");		
		for(Music Allprint : con.Allprint()) {
			System.out.println(Allprint.getSinger() + "-" + Allprint.getTitle());
		}
	}
	public void search() {
		System.out.println("***** 특정 곡 검색(일부만 검색해도 가능) *****");
		String search = sc.nextLine();
		
		try {
			System.out.println(con.search(search).getSinger()+ "-" +
					con.search(search).getTitle()+ " 을/를 검색했습니다");
		} catch (NullPointerException e) {
			System.out.println("없는 노래입니다");
		}
	}

	public void delete() {
		System.out.println("***** 특정 곡 삭제 *****");
		System.out.print("삭제할 곡 명:");
		String delete = sc.nextLine();	
		 Music deletemusic = con.delete(delete);
		if (deletemusic != null) {
	        System.out.println(deletemusic.getSinger() + "-" + deletemusic.getTitle() + " 을/를 삭제했습니다");
	    } else {
	        System.out.println("삭제할 곡이 없습니다.");
	    }
	}
	
	public void rewrite() {
		System.out.print("검색할 곡 명(곡이름과 완전히 일치해주세요):");
		String rewritetarget = sc.nextLine();
		System.out.print("수정할 곡 명:");
		String rewritetitle = sc.nextLine();
		System.out.print("수정할 가수 명:");
		String rewritesinger = sc.nextLine();
		Music beforemusic = con.rewrite(rewritetarget,rewritetitle, rewritesinger);
		if(beforemusic!=null)
		{System.out.println(beforemusic.getSinger()+"-"+beforemusic.getTitle()+"의 값이 변경되었습니다");}
		else System.out.println("수정할 곡을 찾지 못했습니다");
		}
	
	public void singerdownset() {
		 System.out.println("***** 가수 명 내림차순 정렬 *****");
		 con.singerdownset();
		 ArrayList<Music> setmusic = con.Allprint();
		    for (Music set : setmusic) {
		        System.out.println(set.getSinger() + " - " + 
		        		set.getTitle());
		 }
	}
	
	public void singerupset() {
		 System.out.println("***** 가수 명 오름차순 정렬 *****");
		 con.singerupset();
		 ArrayList<Music> setmusic = con.Allprint();
		    for (Music set : setmusic) {
		        System.out.println(set.getSinger() + " - " + 
		        		set.getTitle());
		 }
	}
}