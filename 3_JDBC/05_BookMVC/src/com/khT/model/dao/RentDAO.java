package com.khT.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.khT.model.vo.Book;
import com.khT.model.vo.Rent;

import config.ServerInfo;

public class RentDAO {
	
	public RentDAO() {
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
	
	public boolean checkRentBook(int no) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM rent WHERE rent_book_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		boolean check = rs.next();
		close(rs, ps, conn);
		return check;
	}
	
	public void rentBook(int memberNo, int bookNo) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO rent(rent_mem_no, rent_book_no) VALUES(?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, memberNo);
		ps.setInt(2, bookNo);
		ps.executeUpdate();
		close(ps, conn);
	}
	
	public ArrayList<Rent> printRentBook(int memberNo) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM rent JOIN book ON (rent_book_no = bk_no) WHERE rent_mem_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, memberNo);
		ResultSet rs = ps.executeQuery();
		ArrayList<Rent> list = new ArrayList<>();
		while(rs.next()) {
			
			Rent rent = new Rent();
			rent.setRentNo(rs.getInt("rent_no"));
			rent.setRentDate(rs.getDate("rent_date"));
			
			Book book = new Book();
			book.setBkTitle(rs.getString("bk_title"));
			book.setBkAuthor(rs.getString("bk_author"));
			
			rent.setBook(book);
			
			list.add(rent);
		}
		return list;
		
	}
	
	public int deleteRent(int no) throws SQLException {
		Connection conn = connect();
		String query = "DELETE FROM rent WHERE rent_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		
		int a = ps.executeUpdate();
		close(ps, conn);
		return a;
	}
	
}





