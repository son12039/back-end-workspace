package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Controller - 비즈니스 로직 작성 공간
		
		
		
		
		// 화면단에서 /register으로 요청하여 받기
		
		
		// 1. 있다면 폼값받아오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		// 2. DAO 호출 - DB 접근 필요시
		MemberDAO member = new MemberDAO();
		boolean check = false;
		
		try {
			member.registerMember(id, pwd, name);
			check = true;
		} catch (SQLException e) {
		}
		
//		if (check) {
//			// 3 .바인딩 : 결과 페이지에 서버에서 받은 값 보낼 때
//			request.setAttribute("name", name);
//
//			// 4. 네이게이션 결과 페이지 지정 - result.jsp
//			// response.sendRedirect("result.jsp");
//			// 결과 페이지에 서버에서 받은 값 보내려면 forward쓰셈
//			request.getRequestDispatcher("result.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("fail.jsp");
//		}
		// 중복 여부 판단 후 결과페이지 2개 -> 회원가입성공/실패
		// 결과페이지 1개	 
		request.setAttribute("name", name);
		request.setAttribute("check", check);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		 
		 
	}
	
}
