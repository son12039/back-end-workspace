package com.damoim.controller;

import com.ChattingTest.model.vo.BasicRoomListVo;
import com.damoim.model.dto.ChattingRoomDAO;
import com.damoim.model.dto.MessageDAO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Controller
public class ChattingController {


	
	
	@GetMapping("/chattingserver")
	public String chatting() {
		System.out.println("Chat!!!!!!");
		return "chatting/chatting"; // "main"은 "WEB-INF/jsp/main.jsp"를 가리킴
	}

	


}