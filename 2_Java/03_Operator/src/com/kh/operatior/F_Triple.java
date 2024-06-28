package com.kh.operatior;

import java.util.Scanner;

public class F_Triple {
		
	/*
	 * 삼항 연산자
	 * 
	 * 조건식 ? 값1: 값2;
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다.
	 * - 조건식의 결과가 true이면 값1을 반환한다.
	 * - 조건식의 결과가 false이면 값2를 반환한다.
	 * */
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		F_Triple f = new F_Triple();
//		f.practice1();
//		f.practice2();
		f.practice3();
	}
	public void method1() {
		// 입력받은 정수가 양수인지 음수인지 판단
		System.out.print("정수값 >> ");
		int number = sc.nextInt();
		
		
		// 0이다 포함
		String result =( number == 0 ? "0입니다" :(number > 0 ? "양수" : "음수"));
		System.out.println(result);
		
		
	}
	
	/*
	 * 문제1
	 * 사용자한테 두개의 정수값을 입력받아서 두정수의 곱셈결과가 100보다 크거나 같은경우
	 * "결과가 100이상입니다" 아니면 100보다 작음 출력
	 * 
	 * */
	public void practice1() {
		System.out.print("첫번째 정수입력");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수입력");
		int num2 = sc.nextInt();
		int sum = num1 * num2;
		String result = (sum >= 100) ? "결과가 100이상입니다" : "결과가 100이하 입니다";
		System.out.println(result);
	}
	/*
	 * 문제2
	 * 사용자한테 문자를 하나 입력받아서 입력한 문자가 대문자이면
	 * "알파벳대문자이다" 아니면 아니다 출력
	 * 
	 * */
	public void practice2() {
		System.out.print("문자입력해주세요");
		char ch = sc.nextLine().charAt(0);
		String result = (ch >= 'A' && ch<= 'Z' ) ? "알파벳대문자이다" : "알파벳대문자가 아니다";
		System.out.println(result);
	}

   /*
    * 문제 3
    * 두 정수를 입력받고 + 또는 -를입력받아서 계산을 출력
    * 단, +또는 - 이외의 문자를 입력하는 경우 "잘못입력했습니다." 출력
    * 
    * 예시)
    * 첫번째 수 > 3
    * 두번째 수 > 4
    * 연산자 입력 (+또는 -) > +
    * 3 + 4 =7
    * 
    * 연산자입력 (+또는 - ) > -
    * 3-4 = -1
    * 연산자입력 (+또는 - ) > *
    * 잘못입력했습니다.
    * */
	public void practice3() {
		System.out.print("첫번째 정수입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 정수입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("연산자입력 (+ 또는 -) : ");
		char ar = sc.nextLine().charAt(0);
		String result = (ar == '+' ) ? 
				num1 + " + " +num2 +  "= " + (num1+num2) : ar ==  '-' ?  
				num1 + " - " +num2 +  "= " + (num1-num2) : "잘못입력했습니다"; // + 43 - 45
		System.out.println(result);
		
		result = ar == '+'  
				? String.format("%d + %d = %d", num1,num2,(num1+num2)) :ar ==  '-' 
				? String.format("%d - %d = %d", num1,num2,(num1-num2)): "잘못입력했습니다";
		System.out.println(result);
	}  
		
}

















