package com.khT.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.khT.model.vo.Member;

import config.ServerInfo;

public class MemberDAO {

	public MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		return DriverManager.getConnection
				(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void close(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps,conn);
	}
	
	public void registerMember(String id, String password, String name) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO member(member_id, member_pwd, member_name) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.executeUpdate();
		close(ps, conn);
		
	}
	
	public Member login(String id, String password) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE member_id=? AND member_pwd=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		Member member = new Member();
		if(rs.next()) {
			member.setMemberId(id);
			member.setMemberPwd(password);
			member.setMemberName(rs.getString("member_name"));
			member.setMemberNo(rs.getInt("member_no"));
			member.setStatus(rs.getString("status").charAt(0));
			
		}		
		close(rs, ps, conn);		
		return member;		
	}
	
	
		
}
