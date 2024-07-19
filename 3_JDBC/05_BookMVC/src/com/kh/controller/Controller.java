package com.kh.controller;

import java.sql.*;
import java.util.ArrayList;

import com.kh.model.Book;
import com.kh.model.Member;
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
	
	public Member login(String id,String password) throws SQLException {
		
		Connection conn = getConnect();
		
		String query = "SELECT * FROM member WHERE member_id=? AND member_pwd=?";
		PreparedStatement ps = conn.prepareStatement(query);		
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String Id = rs.getString("member_id");
			String Password = rs.getString("member_pwd");
			if(Id.equals(id)&&Password.equals(password)) {
			Member mb = new Member(rs.getInt("member_no"),Id,Password, rs.getString("member_name"));
			closeAll(rs, ps, conn);
			return mb;
			}
		}
		closeAll(rs, ps, conn);
		return null;		
	}
	
	public boolean deleteMember(String id,String password) throws SQLException {
		
		Connection conn = getConnect();
		String query = 
				"DELETE FROM member WHERE member_id=?AND member_pwd=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);
		boolean a = ps.executeUpdate()==1;
		closeAll(ps, conn);
		return a;		
		
	}
//	select * from rent join member on (member_no=rent_mem_no)

	public ArrayList<Rent> printRentBook(int member_no) throws SQLException {
		Connection conn = getConnect();
		ArrayList<Rent> rentlist = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement
		("SELECT * FROM rent join member on (member_no=rent_mem_no) join book on (bk_no=rent_book_no) WHERE rent_mem_no=?");
		ps.setInt(1, member_no);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		//	대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한(+14일
			int No = rs.getInt("rent_no");
			String Title = rs.getString("bk_title");
			String Author = rs.getString("bk_author");
			Date RD = rs.getDate("rent_date");
			Rent rent = new Rent(No,Title,Author,RD);
			rentlist.add(rent);
		}
		closeAll(rs, ps, conn);
		return rentlist;
	}

	public boolean rentBook(int rentNo,int no) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement
		("SELECT * FROM rent WHERE rent_book_no=?");
		ps.setInt(1, rentNo);
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			PreparedStatement rt = conn.prepareStatement
			("INSERT INTO rent(rent_mem_no, rent_book_no) VALUES(?,?)");
			rt.setInt(1, no);
			rt.setInt(2, rentNo);
			try {
				rt.executeUpdate();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;	
	}
	
	public boolean deleteRent(int deleteRentNo,int no) throws SQLException {
		Connection conn = getConnect();
		PreparedStatement rt = conn.prepareStatement
				("DELETE FROM rent WHERE rent_no=? AND rent_mem_no=?");
		rt.setInt(1, deleteRentNo);
		rt.setInt(2, no);
		try {
			int a = rt.executeUpdate();
			return a>0;
		} catch (Exception e) {
			return false;
		}
			
	}	
	
}
	

