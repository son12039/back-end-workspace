package com.kh.example.practice2;

import com.kh.example.practice2.controller.SnackController;

public class Application {

	public static void main(String[] args) {
		// 데이터들을 서버한테 요청! 서버한테 전달할 때는 컨트롤러로
		SnackController controlloer = new SnackController();
		
		// 서버한테 요청해서 응답받은 결과를 다시 화면으로!
		System.out.println(controlloer.savaData(null, null, null, 0, 0));
		System.out.println(controlloer.confirmData()); 


		
	}

}