package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		
		MemberDAO mb = new MemberDAO();
		try {
			Member m = mb.login(id, pwd);

			HttpSession session = request.getSession();
			session.setAttribute("m", m);
			response.sendRedirect("/index.jsp");
		} catch (Exception e) {
			response.sendRedirect("/index.jsp");
		}
		
		 
	}

}
