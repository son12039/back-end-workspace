package com.kh.step3;

import java.awt.Toolkit;

public class Print extends Thread{
	
	public Print(String name) {
		super(name);
	}
	
	public void run() {
		for(int i =0; i<5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String name = Thread.currentThread().getName();
			System.out.println(name);
		}
	}
}

