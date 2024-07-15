package com.kh.step3;

import java.awt.Toolkit;

public class Sound extends Thread{
	public void run() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			tool.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
	 

