package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/allMember")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		MemberDAO mb = new MemberDAO();
		try {
			ArrayList<Member> list =mb.printAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/allMember.jsp").
			forward(request, response);
		} catch (SQLException e) {
		}
		
	}

}
