package com.kh.condition;

import java.util.Scanner;

public class A_If {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * if문
	 * 
	 * if(조건식) {
	 * 	조건식이 참일 때 실행할 구문
	 * 	}
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 * */
	
	public void methoud1() {
		System.out.print("점수입력 : ");
		int point = Integer.parseInt(sc.nextLine());
		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		if (point >= 60) {
			System.out.println("합격입니다");
		}
		
	}
	/*
	 * if-else문
	 * 
	 * if(조건식) {
	 * 	 조건식이 참일 때 실행
	 * } else {
	 * 	 조건식이 거짓일 때 실행
	 * }
	 * 
	 * */
	public void methoud2() {
		/* System.out.print("점수입력 : ");
		int point = Integer.parseInt(sc.nextLine());
		if (point >= 60) {
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격입니다");
		} */
		
		//삼항연산자
		System.out.print("점수입력 : ");
		int point = Integer.parseInt(sc.nextLine());
		System.out.println((point >= 60) ? "합격입니다" : "불합격입니다");
	}
	
	public void methoud3() {
		System.out.print("이름입력 : ");
		String name = sc.nextLine();
		System.out.println(System.identityHashCode(name));
		String my = "손정배";
		System.out.println(System.identityHashCode(my));
		System.out.println((name.equals(my)) ? "본인입니다" : "본인이 아니다");
	}
	 
	
	public void methoud4() {
		// 입력받은 숫자가 0보다 크면 양수 0이면 0이다 작으면 음수 출력
		// 삼항연산자사용
		System.out.print("숫자입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println((num == 0) ? "0입니다" : 
			num > 0 ? "양수" : "음수");
		
		// else if 사용
		// else if는 제한수가 없음
		
		System.out.print("숫자입력 : ");
		int point = Integer.parseInt(sc.nextLine());
		if (point == 0) {
			System.out.println("0입니다");
		} else if (point > 0){
			System.out.println("양수입니다");
		} else {
		System.out.println("음수입니다");
		}
	}
	
	/*
	 * 사용자에게 점수를 입력받아서 점수별로 등급 출력
	 * 90이상 A
	 * 80 B
	 * 70 C
	 * 60 D
	 *  F
	 * */
	public void practice1() {
		System.out.print("점수입력 : ");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println(
			(score > 100) ? "잘못입력" : 
			(score >= 90) ? "A등급" : 
			(score >= 80) ? "B등급" : 
			(score >= 70) ? "C등급" : 
			(score >= 60) ? "D등급" :  
			(score >= 0)  ? "F등급" : "잘못입력");
	}
	/*
	 * 세 정수를 입력했을 때 짝수만 출력
	 * 
	 * 3 4 6
	 * 4 6
	 * */
	public void practice2() {
		System.out.print("첫번째숫자 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째숫자 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("세번째숫자 : ");
		int num3 = Integer.parseInt(sc.nextLine());
		if (num1%2 == 0) {
			System.out.print(num1 + " ");
		}
		if (num2%2 == 0) {
			System.out.print(num2 + " ");
		}
		if (num3%2 == 0) {
			System.out.print(num3);
		}
	}
	
	/*
	 * 정수 1개를 입력 음 양 0, 짝 홀 출력
	 * */
	public void practice3() {
		System.out.print("숫자 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		if (num == 0) {
			System.out.println("zero");
		} else if (num> 0) {
			System.out.println("plus");
		} else {
			System.out.println("minus");
		}
		if (num%2 == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
		
	}
	public static void main(String[] args) {
		A_If a = new A_If();
//		a.methoud1();
//		a.methoud2();
//		a.methoud3();
//		a.methoud4();
//		a.practice1();
//		a.practice2();
		a.practice3();
	}

}
