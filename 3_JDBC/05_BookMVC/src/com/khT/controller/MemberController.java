package com.khT.controller;

import java.sql.SQLException;

import com.khT.model.dao.MemberDAO;
import com.khT.model.vo.Member;

public class MemberController {
	
	private MemberDAO member = new MemberDAO();
	
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
	
	
	
	
	
	
	
	
	
	
	
	
}
