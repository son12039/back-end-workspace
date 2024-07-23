package com.kh.model.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	
	public MemberDAO() {
		try {
			Class.forName(com.kh.controller.ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		return DriverManager.getConnection
				(com.kh.controller.ServerInfo.URL,com.kh.controller.ServerInfo.USER,
						com.kh.controller.ServerInfo.PASSWORD);
	}
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void close(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps,conn);
	}

	// 회원가입
	 public boolean registerMember(String id, String password, String name) throws SQLException {
		 Connection conn = connect();
		 String query = "INSERT INTO member VALUES(?,?,?)";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ps.setString(1, id);
		 ps.setString(2, password);
		 ps.setString(3, name);
		 int a = ps.executeUpdate();
		 
		 close(ps, conn);
		 return a==1;
	 }
	 public ArrayList<Member> printAll() throws SQLException {
		 ArrayList<Member> mblist = new ArrayList<>();
		 Connection conn = connect();
		 String query = "SELECT * FROM member";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			Member mb = new Member();
					mb.setId(rs.getString("id"));
					mb.setPassword(rs.getString("password"));
					mb.setName(rs.getString("name"));
					mblist.add(mb);
		 }
		 close(rs, ps, conn);
		 return mblist;
	 }
	 
	 public Member print(String id) throws SQLException {
		 Connection conn = connect();
		 String query = "SELECT * FROM member WHERE id=?";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ps.setString(1, id);
		 ResultSet rs = ps.executeQuery();
		 Member mb = null;
		 if(rs.next()) {
			 mb = new Member(rs.getString("id"),rs.getString("password"),
					 rs.getString("name"));
		 	}
		 return mb;
	 }
	 
}
