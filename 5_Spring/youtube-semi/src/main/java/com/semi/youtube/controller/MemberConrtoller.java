package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.youtube.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberConrtoller {
	
	@Autowired
	private MemberService member;
	
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		return member.check(id);
	}
	
	// 로그인
}
