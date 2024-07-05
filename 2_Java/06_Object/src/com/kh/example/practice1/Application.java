package com.kh.example.practice1;

import com.kh.example.practice1.model.Member;

public class Application {

	public static void main(String[] args) {
		Member mb = new Member();
		mb.changeName("손정배");
		mb.printName();
	}
}
