package com.khT.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.khT.model.dao.MemberDAO;
import com.khT.model.dao.RentDAO;
import com.khT.model.vo.Member;
import com.khT.model.vo.Rent;

public class MemberController {
	
	private MemberDAO member = new MemberDAO();
	private RentDAO rent = new RentDAO();
	
	public boolean registerMember(String id, String password, String name) {
		try {
			member.registerMember(id, password, name);
			return true;
		} catch (SQLException e) {
			return false;
		}
		
		
	}
	
	public Member login(String id, String password) {
		try {
			Member m = member.login(id, password);
			if(m.getStatus()=='N')return m;
		} catch (SQLException e) {
		}
		return null;
	}
	
	public boolean deleteMember(int memberNo) {
		
		try {
			// 대여책있으면 탈퇴금지
//			ArrayList<Rent> bookList = rent.printRentBook(memberNo);
//			if(bookList.size() > 0) return false;
			if(member.deleteMember(memberNo)==1) return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
}
