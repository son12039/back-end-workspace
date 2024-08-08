package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.mybatis.service.MemberService;


@Controller
public class AjaxController {

	private int count = 0;
	
	@Autowired
	private MemberService ms;
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		return ++count;
	}
	
	
	@ResponseBody
	@GetMapping("/encoding")
	public String nick(String nick) {
		return nick;
	}
	
	@ResponseBody
	@PostMapping("/check")
	public Member idCheck(String id) {
		return ms.idCheck(id);
	}
	
}
