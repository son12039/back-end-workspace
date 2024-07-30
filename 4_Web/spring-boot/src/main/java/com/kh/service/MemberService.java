package com.kh.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public void register(Member vo) throws SQLException {
		dao.registerMember(vo); 
	}
	
	public Member login(Member vo) throws SQLException {		 
			return dao.login(vo.getId(), vo.getPassword());
	}

	public Member find(String id) throws SQLException {
		return dao.print(id);		
	}

	public ArrayList<Member> allMemberSearch() throws SQLException {
		return dao.printAll();		
	}
	
	
}
