package com.kh.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Rent {
	
	private int rentNo;
	private String rentBkTitle,rentBkAuthor;
	private Date rentDate;
	@Override
	public String toString() {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rentDate);
		
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date redate = calendar.getTime();
		String redate1 = dateFormat.format(redate);
		
		return "대여정보 대여번호: " + rentNo + ", 책이름 " + rentBkTitle + " ,저자 이름 " + rentBkAuthor
				+ ", 대여날짜 " + rentDate + " , 반납날짜 "+redate1;
	}
	
}

