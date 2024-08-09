package com.ChattingTest.controller;

import com.ChattingTest.dto.ChattingRoom;
import com.ChattingTest.dto.Message;
import com.ChattingTest.model.BasicRoomListVo;

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
public class MainController {

	// 채팅방 목록
	public static LinkedList<ChattingRoom> chattingRoomList = new LinkedList<>();

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public void basic() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.10.51:3306/damoim", "root", "qwer1234");
		String query = "SELECT membership_code, membership_name FROM membership";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<BasicRoomListVo> list = new ArrayList();
		 
		while(rs.next()) {
			ChattingRoom chattingRoom = null;
			String roomNumber = UUID.randomUUID().toString();
			chattingRoom = ChattingRoom.builder().roomNumber(rs.getString("membership_code"))
				.users(new LinkedList<>()).roomName(rs.getString("membership_name")+"(클럽회원전용)").build();
			System.out.println(chattingRoom);
			chattingRoomList.add(chattingRoom);
		}
		close(rs, ps, conn);
		
	}
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps, conn);
	}
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// 유틸 메서드
	
	// 방 번호로 방 찾기
	public ChattingRoom findRoom(String roomNumber) {
		ChattingRoom room = ChattingRoom.builder().roomNumber(roomNumber).build();
		int index = chattingRoomList.indexOf(room);
		return chattingRoomList.contains(room) ? chattingRoomList.get(index) : null;
	}

	// 쿠키에 추가
	public void addCookie(String cookieName, String cookieValue) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletResponse response = attr.getResponse();
		Cookie cookie = new Cookie(cookieName, cookieValue);
		int maxage = 60 * 60 * 24 * 7;
		cookie.setMaxAge(maxage);
		response.addCookie(cookie);
	}

	// 방 번호, 닉네임 쿠키 삭제
	public void deleteCookie() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletResponse response = attr.getResponse();

		Cookie roomCookie = new Cookie("roomNumber", null);
		Cookie nicknameCookie = new Cookie("nickname", null);

		roomCookie.setMaxAge(0);
		nicknameCookie.setMaxAge(0);

		response.addCookie(nicknameCookie);
		response.addCookie(roomCookie);
	}

	// 쿠키에서 방번호, 닉네임 찾기
	public Map<String, String> findCookie() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();

		Cookie[] cookies = request.getCookies();
		String roomNumber = "";
		String nickname = "";

		if (cookies == null) {
			return null;
		}

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ("roomNumber".equals(cookies[i].getName())) {
					roomNumber = cookies[i].getValue();
				}
				if ("nickname".equals(cookies[i].getName())) {
					nickname = cookies[i].getValue();
				}
			}

			if (!"".equals(roomNumber) && !"".equals(nickname)) {
				Map<String, String> map = new HashMap<>();
				map.put("nickname", nickname);
				map.put("roomNumber", roomNumber);

				return map;
			}
		}

		return null;
	}

	// 닉네임 생성
	public void createNickname(String nickname) { // 방입장할때 닉넴 생성 후 쿠키에 저장
		addCookie("nickname", nickname);
	}

	// 닉네임 중복확인 메서드
	public boolean isNicknameTaken(String roomNumber, String nickname) {
		ChattingRoom room = findRoom(roomNumber);
		if (room == null)
			return false;

		return room.getUsers().contains(nickname);
	}

	// 방 입장하기
	public boolean enterChattingRoom(ChattingRoom chattingRoom, String nickname) {

		if (isNicknameTaken(chattingRoom.getRoomNumber(), nickname)) {
			System.out.println(nickname + "은 중복된 닉네임!");
			return false; // 닉네임 중복
		}

		createNickname(nickname);

		if (chattingRoom == null) {
			deleteCookie();
			return false;
		} else {
			LinkedList<String> users = chattingRoom.getUsers();
			users.add(nickname);

			addCookie("roomNumber", chattingRoom.getRoomNumber());
			return true;
		}
	}

	// ----------------------------------------------------

	// 컨트롤러

	// 메인화면
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", "테스트!");
		return "chatting"; // "main"은 "WEB-INF/jsp/main.jsp"를 가리킴
	}

	// 채팅방 목록
	@GetMapping("/chattingRoomList")
	public ResponseEntity<?> chattingRoomList() throws Exception {
		if(chattingRoomList.size()<3)basic();
		return new ResponseEntity<LinkedList<ChattingRoom>>(chattingRoomList, HttpStatus.OK);
	}
	// (url: "/chattingRoomList")로 호출되어 채팅리스트를 리턴한다

	// 새 채팅방 만들기 -----------------------------------------------------------

	@PostMapping("/chattingRoom")
	public ResponseEntity<?> chattingRoom(String roomName, String nickname) throws Exception {
		// 방을 만들고 채팅방목록에 추가
		 
		ChattingRoom chattingRoom = null;
		String roomNumber = UUID.randomUUID().toString();
		chattingRoom = ChattingRoom.builder().roomNumber(roomNumber).users(new LinkedList<>()).roomName(roomName)
				.build();

		chattingRoomList.add(chattingRoom);
		// 방 입장하기
		enterChattingRoom(chattingRoom, nickname);
		return new ResponseEntity<>(chattingRoom, HttpStatus.OK);
	}
	// 새 채팅방 만들기끝 -----------------------------------------------------------

	 


}