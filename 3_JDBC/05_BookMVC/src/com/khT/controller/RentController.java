package com.khT.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.khT.model.dao.RentDAO;
import com.khT.model.vo.Rent;

public class RentController {

	private RentDAO rent = new RentDAO();
	
	public boolean rentBook(int memberNo, int bookNo) {
		
		try {
			if(!rent.checkRentBook(bookNo)) {
				rent.rentBook(memberNo, bookNo);
				return true;
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Rent> printRentBook(int memberNo) {
		try {
			return rent.printRentBook(memberNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean deleteRent(int no) {
		try {
			if( rent.deleteRent(no) == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
}
