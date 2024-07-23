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

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO m = new MemberDAO();
		ArrayList<Member> mlist = new ArrayList();
		try {
			 mlist = m.printAll();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("mlist", mlist);
		request.getRequestDispatcher("view.jsp").forward(request, response);
				
	}

}
