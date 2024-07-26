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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		String id = request.getParameter("id");
		
		MemberDAO mb = new MemberDAO();
		 Member user = new Member();
		
		try {
			  user = mb.print(id);
			  if(user!=null) {
					request.setAttribute("user", user);
					request.getRequestDispatcher("/views/search_ok.jsp").
					forward(request, response);
			  } else {
				  response.sendRedirect("views/search_fail.jsp");
			  }
	 
		} catch (SQLException e) {
			response.sendRedirect("views/search_fail.jsp");
		}

		
	}

}
