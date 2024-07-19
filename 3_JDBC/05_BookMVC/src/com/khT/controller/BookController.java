package com.khT.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.khT.model.dao.BookDAO;
import com.khT.model.dao.RentDAO;
import com.khT.model.vo.Book;

public class BookController {

	private BookDAO book = new BookDAO();
	private RentDAO rent = new RentDAO();
	public ArrayList<Book> printBookAll(){
		try {
			return book.printBookAll();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean registerBook(String title, String author) {
		try {
			if(!book.checkBook(title, author)) {
				book.registerBook(title, author);
				return true;
			}
		} catch (SQLException e) {}
		return false;
		
	}
	
	public boolean sellBook(int no) {
		
		try {
			if(rent.checkRentBook(no)) {
				return false;
			}
			for(Book b : book.printBookAll()) {
				if(b.getBkNo()==no) {
					book.sellBook(no);
					return true;
				}
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
}
