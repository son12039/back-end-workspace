package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;



public class MemberController {
		
	public boolean signUp(String id,String password,String name) throws SQLException {
		
		Connection conn = getConnect();

		String query = "INSERT INTO member(id, password, name) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		try {
			return ps.executeUpdate()==1;
		} catch (SQLIntegrityConstraintViolationException e) {
			return false;
		}

	}
	
	public String login(String id,String password) throws SQLException {
		
		Connection conn = getConnect();
		
		String query = "SELECT * from member WHERE id = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String Id = rs.getString("id");
			String Password = rs.getString("password");
			if(Id.equals(id)&&Password.equals(password)) {
				return rs.getString("name");
			}
		}
		
		return null;
		// 로그인 기능 구현! 
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		
	}
	
	public boolean changePassword(String id,String password,String newpassword) throws SQLException {
		
		Connection conn = getConnect();
		
		String query = "UPDATE member SET password = ? WHERE id = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, newpassword);
		ps.setString(2, id);
		ps.setString(3, password);
		return ps.executeUpdate()==1;
		
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경

	}
	
	public void changeName(String id, String password, String newName) throws SQLException {
		
		Connection conn = getConnect();
		
		String query = "UPDATE member SET name = ? WHERE id = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, newName);
		ps.setString(2, id);
		ps.setString(3, password);
		ps.executeUpdate();
		
	}

		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		
	
	
	public MemberController() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	

	

	


}









