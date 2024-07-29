package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller{
	

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		MemberDAO mb = new MemberDAO();
		
			Member m = mb.login(id, pwd);
			HttpSession session = request.getSession();
			session.setAttribute("m", m);
		
			return new ModelAndView("index.jsp");
	}
}
