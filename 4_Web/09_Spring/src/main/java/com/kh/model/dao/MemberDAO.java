package com.kh.model.dao;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kh.controller.ServerInfo;
import com.kh.model.vo.Member;

@Repository
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
				("jdbc:mysql://localhost:3306/member","root","qwer1234");
	}
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void close(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps,conn);
	}
	
	public void registerMember(Member member) throws SQLException {
		 Connection conn = connect();
		 String query = "INSERT INTO member VALUES(?,?,?)";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ps.setString(1, member.getId());
		 ps.setString(2, member.getPassword());
		 ps.setString(3, member.getName());
		 ps.executeUpdate();
		 close(ps, conn);
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
	
	 public Member login(String id,String pwd) throws SQLException {
		 Connection conn = connect();
		 String query = "SELECT * FROM member WHERE id=? AND password=?";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ps.setString(1, id);
		 ps.setString(2, pwd);
		 ResultSet rs = ps.executeQuery();
		 Member m = null;
		 if(rs.next()) {
			 m = new Member();
			 m.setId(rs.getString("id"));
			 m.setPassword(rs.getString("password"));
			 m.setName(rs.getString("name"));
			 
		 }
		 close(rs, ps, conn);
		 return m;

	 }
	
}
