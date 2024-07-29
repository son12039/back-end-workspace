package com.kh.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class ModelAndView {
	
	private String path;
	private boolean isRedirect;
	
	// path만 가지는 생성자
	public ModelAndView(String path) {
		this.path = path;
		this.isRedirect = false;
	}
}
