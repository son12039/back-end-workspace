package com.kh.controller.component;

import org.apache.tomcat.util.net.AbstractEndpoint.Handler;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberDAO mb = new MemberDAO();
		Member user = new Member();

		
			user = mb.print(id);
			if (user != null) {
				request.setAttribute("user", user);
				return new ModelAndView("/views/search_ok.jsp");
			} else {
				return new ModelAndView("/views/search_fail.jsp", true);
			}
	}

}
