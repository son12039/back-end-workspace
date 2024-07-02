package com.kh.array;

import java.util.Arrays;

public class B_Dimension {
	
	/*
	 * 다차원 배열 : '[]'의 개수가 차원의 수를 의미
	 * 
	 * * 2차원 배열의 선언
	 * 자료형[][] 배열명;
	 * 자료형 배열명[][];
	 * 자료형[] 배열명[];
	 * 
	 * * 2차원 배열의 생성
	 * 배열명 = new 자료형[행크기][열크기];
	 * 
	 * * 2차원 배열의 선언과 초기화를 동시 진행
	 * 자료형[][] 배열명 = new 자료형[행크기][열크기];
	 * 
	 * 배열명[0][0] = 값;
	 * 배열명[0][1] = 값;
	 * ...
	 * */
	// 선언과 동시에 초기화
	public void method1() {
		int[][] arr = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15}
			 
		};
		int[][] arr2 = new int[3][5];
		int k = 1;
		for (int i=0; i<arr2.length; i++) {
			for (int j=0; j<arr2[i].length; j++) {
				arr2[i][j] = k;
				k += 1;
				System.out.println((arr2[i][j]));
			} 
		}
		/*
		 * [1,2,3,4,5]
		 * [6,7,8,9,10]
		 * */
		
	}
	
	// 가변 배열 : 다차원 배열에서 마지막 차수의 크기를 지정하지 않고 다르게 지정
	/*
	 * [HTML, CSS, JavaScript]
	 * [MySQL, Java, JDBC, Servlet, JSP]
	 * [jQurery, MyBatis, Spring]
	 * [Spring Boot, React]
	 * */
	public void method2() {
		String[][] arr2 = {
		{"HTML", "CSS", "JavaScript"},
		{"MySQL", "Java", "JDBC", "Servlet","JSP"},
		{"jQurery", "MyBatis", "Spring", "Spring Security"},
		{"Spring Boot", "JPA", "QueryDSL", "React", "StyledComponents", "Redux"}
		};
		for(int i = 0; i<arr2.length; i++)
		System.out.println(Arrays.toString(arr2[i]));
		
	}
		public static void main(String[] args) {
		B_Dimension b =new B_Dimension();
//		b.method1();
		b.method2();
	}

}
