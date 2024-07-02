package com.kh.practice;

import java.util.Scanner;

class LoopPractice {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
		l.method2();
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("숫자입력 : ");
    	int num = Integer.parseInt(sc.nextLine());
    	for (int i = 0; i<num; i++) {
    		System.out.println(num-i);
    	}
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	int num = 1;
    	int sum = 0;
    	while(true) {
    		sum += num;
    		if (sum >= 100) {System.out.println(num); break;}
     		if (num >= 0) {
     			num++;
        		num *= -1;
     		} else {
     			num--;
        		num *= -1;
     		}
    	} 
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	int count = 0;
    	System.out.print("문자열입력 : ");
    	String str = sc.nextLine();
    	System.out.print("검색할 문자 입력 : ");
    	char strcheck = sc.nextLine().charAt(0);
    	for (int i=0; i<str.length();i++ ) {
    		if (str.charAt(i)==strcheck) {
    			count +=1;
    		}
    	} System.out.println(str + " 안에 포함된 "+ strcheck + " 개수 :" + count);
    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	int num = 1;
    	System.out.println(num);
    	while (num != 0) {
    		num = (int)(Math.random()*10);
    		System.out.println(num);
    	}; 
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	int dice = 0;
    	int a1 = 0;
    	int a2 = 0;
    	int a3 = 0;
    	int a4 = 0;
    	int a5 = 0;
    	int a6 = 0;
    	for (int i = 0; i<10; i++) {
    		dice = (int)(Math.random()*6+1);
    		if (dice == 1) {
    			a1 += 1;
    		} else if (dice == 2){
    			a2 += 1;
    		} else if (dice == 3){
    			a3 += 1;
    		} else if (dice == 4){
    			a4 += 1;
    		} else if (dice == 5){
    			a5 += 1;
    		} else if (dice == 6){
    			a6 += 1;
    		} 
    	} System.out.println(1 + " : " + a1);
    	System.out.println(2 + " : " + a2);
    	System.out.println(3 + " : " + a3);
    	System.out.println(4 + " : " + a4);
    	System.out.println(5 + " : " + a5);
    	System.out.println(6 + " : " + a6);
    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	String ai = "";
    	System.out.print("이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	while (true ) {
    	System.out.print("가위바위보 : ");
    	String rsp = sc.nextLine();
    	int ran = (int)(Math.random()*3+1);
    	if (ran == 1) {
    		ai = "가위";
    	} else if (ran == 2) {
    		ai = "바위";
    	} else {
    		ai = "보";
    	}
    	if (rsp.charAt(0) == '가') {
    		if (ai.charAt(0) == '가') {
    			System.out.println("비겼습니다");
    			b += 1;
    			
    		} else if (ai.charAt(0) == '보'){
    			a += 1;
    			System.out.println("컴퓨터 : " + ai);
    	    	System.out.println(name + " : " + rsp);
    	    	System.out.println("이겼습니다 !");
    	      	System.out.println("비긴 횟수 : " + b + ", 진 횟수 : " + c + ", 이긴 횟수 : " + a);
    			break;
    		} else if (ai.charAt(0) == '바') {
    			System.out.println("졌습니다 ㅠㅠ");
    			c += 1;
    		}
    	} 
    	else if (rsp.charAt(0) == '바') {
    		if (ai.charAt(0) == '가') {
    			a += 1;
    			System.out.println("컴퓨터 : " + ai);
    	    	System.out.println(name + " : " + rsp);
    	    	System.out.println("이겼습니다 !");
    	      	System.out.println("비긴 횟수 : " + b + ", 진 횟수 : " + c + ", 이긴 횟수 : " + a);
    			break;
    		} else if (ai.charAt(0) == '보'){
    			System.out.println("졌습니다 ㅠㅠ");
    			c += 1;
    		} else if (ai.charAt(0) == '바') {
    			System.out.println("비겼습니다");
    			b += 1;
    	}  
    	else if (rsp.charAt(0) == '보') {
    		if (ai.charAt(0) == '가') {
    			System.out.println("졌습니다 ㅠㅠ");
    			c += 1;
    		  }
    		} else if (ai.charAt(0) == '보'){
    			System.out.println("비겼습니다");
    			b += 1;
    		} else if (ai.charAt(0) == '바') {
    			a += 1;
    			System.out.println("컴퓨터 : " + ai);
    	    	System.out.println(name + " : " + rsp);
    	    	System.out.println("이겼습니다 !");
    	      	System.out.println("비긴 횟수 : " + b + ", 진 횟수 : " + c + ", 이긴 횟수 : " + a);
    			break;
		} 
    	}
    }
  }
}