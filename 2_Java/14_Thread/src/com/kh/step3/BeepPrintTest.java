package com.kh.step3;

public class BeepPrintTest {

	public static void main(String[] args) {
		
		Sound s = new Sound();
		Print p = new Print("띵~");
		s.start();
		p.start();
	}
}
