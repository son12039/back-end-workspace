package com.kh.loop;

import java.util.Scanner;

public class D_While {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * while문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * }
	 * */
	// 1~5까지 출력 : for -> while
	public void method1() {
		int i = 1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
	}
	/*
	 * 무한루프 & break 문
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중헙되는 경우 break문이 포함되어있는 반복문에서만 빠져나간다.
	 * */
	public void method2() {
		while(true) {
			System.out.print("숫자 입력 : ");
			int num =sc.nextInt();
			System.out.println(num);
			if(num == 0) { System.out.println("그만");break;}
				
		}
	}
	
	/*
	 * do {
	 * 		실행코드
	 * } while(조건식);
	 * 
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * - 거의 쓸일이 없음...
	 * 
	 * */
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		System.out.println();
		
		do {
			System.out.println("do-while");
		} while(number == 0) ;
	}
	
	/*
	 * 숫자 맞히기 게임
	 * 1과 100사이의 값을 입력해서 임의로 지정한 random값을 맞히면 게임 끝
	 * 게임 끝나면 몇 번만에 맞쳤는지 출력
	 * 
	 * */
	public void method4() {
		double answer = Math.random()*100+1;
		int num = 0;
		int count = 0;
		while((int)answer != num) {
			System.out.print("숫자입력 : ");
			num = Integer.parseInt(sc.nextLine());
			if ((int)answer>num) {
				System.out.println("더 큰 수를 입력하세요");
				count += 1;
			} else if ((int)answer<num){
				System.out.println("더 작은 수를 입력하세요");
				count += 1;
			}
			
		} System.out.println(count + "번 만에 성공"); 
	}
	
	/*
	 * ------------------------------
	 * 1.예금 | 2.출금 | 3. 잔고 | 4. 종료
	 * ------------------------------
	 * 선택 > 1
	 * 예금액 > 5000
	 * ------------------------------
	 * 1.예금 | 2.출금 | 3. 잔고 | 4. 종료
	 * ------------------------------
	 * 선택 > 2
	 * 출금액 > 2000
	 * ------------------------------
	 * 1.예금 | 2.출금 | 3. 잔고 | 4. 종료
	 * ------------------------------
	 * 선택 > 3
	 * 잔고 > 3000
	 * ------------------------------
	 * 1.예금 | 2.출금 | 3. 잔고 | 4. 종료
	 * ------------------------------
	 * 선택 > 4
	 * 프로그램 종료
	 * */
	public void method5() {
		int money = 0;
		while (true) {
		System.out.println("------------------------------");
		System.out.println("1.예금 | 2.출금 | 3. 잔고 | 4. 종료");
		System.out.println("------------------------------");
		System.out.print("메뉴숫자입력 : ");	
		int num = Integer.parseInt(sc.nextLine());
		if (num == 1) {
			System.out.println("선택 > " + num);
			System.out.print("예금액입력  : ");		
			int num1 = Integer.parseInt(sc.nextLine());
			money += num1;
			System.out.println("예금액 > " + (num1));
		} else if (num == 2) {
			System.out.println("선택 > " + num);
			System.out.print("출금액입력  : ");
			int num1 = Integer.parseInt(sc.nextLine());
			if (money<num1) {System.out.println("잔고가 부족합니다");}
			else {money -= num1;}
			System.out.println("출금액 > " + (num1));
		} else if (num == 3) {
			System.out.println("선택 > " + num);
			System.out.println("잔고 > " + money);
		} else if (num == 4) {
			System.out.println("선택 > " + num);
			System.out.println("프로그램 종료");
			return;
		} else {
			System.out.println("잘못된 접근");
		}
		}
	}
	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
		d.method5();
	}

}
