package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Book {
	
	private int no;
	private String title;
	private String author;
	private int price;
	private int pub_no;
	@Override
	public String toString() {
		return "책번호:" + no + ", 이름: " + title + ", 저자: " + author + 
				", 가격: " + price + ", 출판번호: " + pub_no;
	}
	
}
