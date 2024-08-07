package com.khT.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * VO(Value Object)
 * - 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체
 * */
@Data @NoArgsConstructor @AllArgsConstructor
public class Book {

	private int bkNo;
	private String bkTitle;
	private String BkAuthor;
	private int bkPrice;
	private int bkPubNo;
	private Publisher publisher;
	
}
