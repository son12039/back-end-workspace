package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	public static void main(String[] args) {
		VariablePractice m1 = new VariablePractice();
		
		m1.method6();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		
		System.out.println(10000*2 + 7000*3 +"원");
		System.out.println("-----");
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		int a;
		a = x;
		x = y;
		y = z;
		z = a;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
		
		
		System.out.println("-----");
	}

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		
		int a = 23;
		int b = 7;
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		
		System.out.println("-----");
	}

	/*
	 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("가로값입력 ");
		double a = Double.parseDouble(sc.nextLine());
		System.out.print("세로값입력 ");
		double b = Double.parseDouble(sc.nextLine());
			
		System.out.println
		("면적 :" + a * b);
		System.out.println
		("둘레 :" + (a + b) * 2);
		System.out.println("-----");
	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String apl = sc.nextLine();
		char a0 = apl.charAt(0);
		char a1 = apl.charAt(1);
		char a4 = apl.charAt(4);
		System.out.println("첫번째 문자 :" + a0);
		System.out.println("첫번째 문자 :" + a1);
		System.out.println("첫번째 문자 :" + a4);
		
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : ");
		char a =  sc.nextLine().charAt(0);
		int aa = a;
		System.out.println("A unicode :" + aa);
	 System.out.println("B unicode :" + (aa+1));
	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 :");
		double kr = Double.parseDouble(sc.nextLine());
		
		System.out.print("영어 :");
		double en = Double.parseDouble(sc.nextLine());
		
		System.out.print("수학 :");
		double ma = Double.parseDouble(sc.nextLine());
		int sum = (int)(kr+en+ma) ;
		double arg = ((kr+en+ma) / 3);
		
		System.out.printf("총점 : %d",sum);
		System.out.println();
		System.out.printf("평균 : %.2f",arg);
	}

}
