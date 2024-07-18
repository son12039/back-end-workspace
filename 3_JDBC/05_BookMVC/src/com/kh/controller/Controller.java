package com.kh.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.Book;
import com.kh.model.Rent;

import config.ServerInfo;

public class Controller {

	public Controller() {
		try {

			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Controller instance;

	public static Controller getInstance() {
		if (instance == null)
			instance = new Controller();
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
	
	public boolean registerBook(String title,String author) throws SQLException {
		
		Connection conn = getConnect();
		
		String querysearch = "SELECT bk_title,bk_author FROM book WHERE bk_title=? OR bk_author=?";
		PreparedStatement ps2 = conn.prepareStatement(querysearch);
		ps2.setString(1, title);
		ps2.setString(2, author);
		ResultSet rs = ps2.executeQuery();
		if(!rs.next()) {
			String query = "INSERT INTO book(bk_title,bk_author) VALUES (?,?)";
			PreparedStatement ps1 = conn.prepareStatement(query);
			ps1.setString(1, title);
			ps1.setString(2, author);
			ps1.executeUpdate();
			return true;
		}else {
			return false;
		}		
	}
	
	public ArrayList<Book> printBookAll() throws SQLException {
		
		Connection conn = getConnect();
		ArrayList<Book> booklist = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM book");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Book book = new Book(rs.getInt("bk_no"),rs.getString("bk_title"),
					rs.getString("bk_author"), rs.getInt("bk_price"), rs.getInt("bk_pub_no"));
			booklist.add(book);
		}
		closeAll(rs, ps, conn);
		return booklist;
	}
	
	public boolean sellBook(int no) throws SQLException {
		
	Connection conn = getConnect();
		
		String querysearch = "DELETE FROM book WHERE bk_no=?";
		PreparedStatement ps = conn.prepareStatement(querysearch);

		ps.setLong(1, no);		
		try {
			 ps.executeUpdate();
			 closeAll(ps, conn);
			return true;
		} catch (Exception e) {
			closeAll(ps, conn);
			return false;
		}

	}
	
	public boolean registerMember(String id,String password,String name) throws SQLException {
		
		Connection conn = getConnect();
		
		String query = "INSERT INTO member(member_id,member_pwd,member_name) VALUES (?,?,?)";
		PreparedStatement ps1 = conn.prepareStatement(query);
		ps1.setString(1, id);
		ps1.setString(2, password);
		ps1.setString(3, name);
		try {
			ps1.executeUpdate();		
			closeAll(ps1, conn);			
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	public String login(String id,String password) throws SQLException {
		
		Connection conn = getConnect();
		
		String query = "SELECT member_id,member_pwd,member_name FROM member WHERE member_id=? AND member_pwd=?";
		PreparedStatement ps = conn.prepareStatement(query);		
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String Id = rs.getString("member_id");
			String Password = rs.getString("member_pwd");
			if(Id.equals(id)&&Password.equals(password)) {
				String a = rs.getString("member_name");
				closeAll(rs, ps, conn);
				return a;
			}
		}
		closeAll(rs, ps, conn);
		return null;
		
		
	}
	
	public boolean deleteMember(String id,String password) throws SQLException {
		
		Connection conn = getConnect();
		String query = 
				"DELETE FROM member  WHERE member_id=?AND member_pwd=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		closeAll(ps, conn);
		return ps.executeUpdate()==1;		
		
	}
//	select * from rent join member on (member_no=rent_mem_no)

	public ArrayList<Rent> printRentBook() throws SQLException {
		Connection conn = getConnect();
		ArrayList<Rent> rent = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM rent");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Book book = new Book(rs.getInt("bk_no"),rs.getString("bk_title"),
					rs.getString("bk_author"), rs.getInt("bk_price"), rs.getInt("bk_pub_no"));
			rent.add(null);
		}
		closeAll(rs, ps, conn);
		return rent;
	}
	
	
	
	
}
