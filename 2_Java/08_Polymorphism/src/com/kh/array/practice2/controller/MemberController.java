package com.kh.array.practice2.controller;


import com.kh.array.practice2.model.Member;

public class MemberController{
	private static Member member = new Member();
	private static String[] mArr = new String[3];
	
	
	public void add(String id, String name, String pwd, String email, char gender, int age) {
		member.setId(id);
		member.setName(name);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setGender(gender);
		member.setAge(age);
		System.out.println(member.getId());
	}
	
	public void add1() {
		
	}
	
	public void print() {

	}	
}

/*
 * for(int j=0; j<3; j++) {
				
			}*/