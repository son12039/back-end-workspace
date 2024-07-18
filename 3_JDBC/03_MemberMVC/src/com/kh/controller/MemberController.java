package com.kh.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Properties;



public class MemberController {
	
	Properties p = new Properties();
	// 싱글톤 패턴(Signleton Pattern)
	// - 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	
	// 1. 생성자는 private
	public MemberController() {
		try {
						 
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2. 유일한 객체를 담을 static 변수
	 private static MemberController instance;
	
	// 3. 객체를 반환하는 static 메서드
	 public static MemberController getInstance() {
		 if(instance == null) instance = new MemberController();
		 return instance;
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
	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("idCheck"));
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null;
		if(rs.next()) checkId = rs.getString("id");
		closeAll(rs, ps, conn);
		
		return (checkId!=null);

	}
		
		
		
	public boolean signUp(String id,String password,String name) throws SQLException {
		
		Connection conn = getConnect();

		PreparedStatement ps = conn.prepareStatement(p.getProperty("signUp"));
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		try {
			boolean a = 1 == ps.executeUpdate();
			closeAll(ps, conn);
			return a;
		} catch (SQLIntegrityConstraintViolationException e) {
			return false;
		}

	}
	
	public String login(String id,String password) throws SQLException {
		
		Connection conn = getConnect();
		
		PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String Id = rs.getString("id");
			String Password = rs.getString("password");
			if(Id.equals(id)&&Password.equals(password)) {
				String a = rs.getString("name");
				closeAll(rs, ps, conn);
				return a;
			}
		}
		
		return null;
		// 로그인 기능 구현! 
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		
	}
	
	public boolean changePassword(String id,String password,String newpassword) throws SQLException {
		
		Connection conn = getConnect();
		
		PreparedStatement ps = conn.prepareStatement(p.getProperty("changePassword"));
		ps.setString(1, newpassword);
		ps.setString(2, id);
		ps.setString(3, password);
		boolean a = ps.executeUpdate()==1;
		closeAll(ps, conn);
		return a;
		
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경

	}
	
	public void changeName(String id, String password, String newName) throws SQLException {
		
		Connection conn = getConnect();
		
		PreparedStatement ps = conn.prepareStatement(p.getProperty("changeName"));
		ps.setString(1, newName);
		ps.setString(2, id);
		ps.setString(3, password);
		ps.executeUpdate();
		closeAll(ps, conn);
		
	}

		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		
	
	

	

	

	
	
	


}









