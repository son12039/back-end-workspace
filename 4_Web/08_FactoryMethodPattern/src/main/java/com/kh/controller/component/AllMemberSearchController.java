package com.kh.controller.component;

import java.util.ArrayList;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AllMemberSearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mb = new MemberDAO();
		ArrayList<Member> list =mb.printAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/allMember.jsp").
		forward(request, response);
		return new ModelAndView("/views/allMember.jsp");
	}

}
