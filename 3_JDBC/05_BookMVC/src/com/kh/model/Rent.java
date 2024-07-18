package com.kh.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Rent {
	
	private int rent_no, rent_mem_no, rent_book_no;
	private Date rent_date;
}
