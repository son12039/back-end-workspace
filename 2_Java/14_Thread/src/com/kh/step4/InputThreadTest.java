package com.kh.step4;

public class InputThreadTest {

// 프로세스 - 두 스레드 간의 Communication은 프로세스의 자원으로 해야한다.
	boolean check =false;	
	
	public static void main(String[] args) {
		
		InputThreadTest process = new InputThreadTest();
		
		Input i = new Input(process);
		Counting c = new Counting(process);
		c.start();
		i.start();
	}
}
