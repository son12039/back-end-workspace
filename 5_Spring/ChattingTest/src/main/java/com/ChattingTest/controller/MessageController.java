package com.ChattingTest.controller;

import java.util.Map;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ChattingTest.dto.Message;

@Controller
public class MessageController {

	// 여기서 메세지가 오면 방목록 업데이트
	@MessageMapping("/socket/roomList")
	@SendTo("/topic/roomList")
	public String roomList() {
		return "";
	}

	// 채팅방에서 메세지 보내기
	@MessageMapping("/socket/sendMessage/{roomNumber}")
	@SendTo("/topic/message/{roomNumber}")
	public Message sendMessage(@DestinationVariable String roomNumber, Message message) {
		return message;
	}

	// 채팅방에 입장 퇴장 메세지 보내기
	@MessageMapping("/socket/notification/{roomNumber}")
	@SendTo("/topic/notification/{roomNumber}")
	public Map<String, Object> notification(@DestinationVariable String roomNumber, Map<String, Object> chattingRoom) {
		return chattingRoom;
	}
}
