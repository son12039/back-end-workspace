package com.example.controller;

import com.example.dto.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

@Controller
public class MainController {

    // 채팅방 목록
    public static LinkedList<ChattingRoom> chattingRoomList = new LinkedList<>();


    //	----------------------------------------------------
    // 유틸 메서드

    // 방 번호로 방 찾기
    public ChattingRoom findRoom(String roomNumber) {
        ChattingRoom room = ChattingRoom.builder().roomNumber(roomNumber).build();
        int index = chattingRoomList.indexOf(room);

        if(chattingRoomList.contains(room)) {
            return chattingRoomList.get(index);
        }
        return null;
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
    public void deleteCookie( ) {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletResponse response = attr.getResponse();

        Cookie roomCookie = new Cookie("roomNumber", null);
        Cookie nicknameCookie = new Cookie("nickname",null);

        roomCookie.setMaxAge(0);
        nicknameCookie.setMaxAge(0);

        response.addCookie(nicknameCookie);
        response.addCookie(roomCookie);
    }



    // 쿠키에서 방번호, 닉네임 찾기
    public Map<String, String> findCookie() {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();

        Cookie[] cookies = request.getCookies();
        String roomNumber = "";
        String nickname= "";

        if(cookies == null) {
            return null;
        }

        if(cookies != null) {
            for(int i=0;i<cookies.length;i++) {
                if("roomNumber".equals(cookies[i].getName())) {
                    roomNumber = cookies[i].getValue();
                }
                if("nickname".equals(cookies[i].getName())) {
                    nickname = cookies[i].getValue();
                }
            }

            if(!"".equals(roomNumber) && !"".equals(nickname)) {
                Map<String, String> map = new HashMap<>();
                map.put("nickname", nickname);
                map.put("roomNumber", roomNumber);

                return map;
            }
        }

        return null;
    }

    // 닉네임 생성
    public void createNickname(String nickname) {
        addCookie("nickname", nickname);
    }

    // 방 입장하기
    public boolean enterChattingRoom(ChattingRoom chattingRoom, String nickname) {
        createNickname(nickname);

        if(chattingRoom == null) {
            deleteCookie();
            return false;
        } else {
            LinkedList<String> users = chattingRoom.getUsers();
            users.add(nickname);

            addCookie("roomNumber", chattingRoom.getRoomNumber());
            return true;
        }
    }


    //	----------------------------------------------------

    // 컨트롤러

    // 메인화면
    @GetMapping("/")
    public String main() {
        return "main";
    }


    // 채팅방 목록
    @GetMapping("/chattingRoomList")
    public ResponseEntity<?> chattingRoomList() {
        return new ResponseEntity<LinkedList<ChattingRoom>>(chattingRoomList, HttpStatus.OK);
    }


    // 방 만들기
    @PostMapping("/chattingRoom")
    public ResponseEntity<?> chattingRoom(String roomName, String nickname) {

        // 방을 만들고 채팅방목록에 추가
        String roomNumber = UUID.randomUUID().toString();
        ChattingRoom chattingRoom = ChattingRoom.builder()
                .roomNumber(roomNumber)
                .users(new LinkedList<>())
                .roomName(roomName)
                .build();

        chattingRoomList.add(chattingRoom);

        // 방 입장하기
        enterChattingRoom(chattingRoom, nickname);

        return new ResponseEntity<>(chattingRoom, HttpStatus.OK);
    }


    // 방 들어가기
    @GetMapping("/chattingRoom-enter")
    public ResponseEntity<?> EnterChattingRoom(String roomNumber, String nickname){

        // 방 번호로 방 찾기
        ChattingRoom chattingRoom = findRoom(roomNumber);

        if(chattingRoom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // 방 들어가기
            enterChattingRoom(chattingRoom, nickname);

            return new ResponseEntity<>(chattingRoom, HttpStatus.OK);
        }
    }

    // 방 나가기
    @PatchMapping("/chattingRoom-exit")
    public ResponseEntity<?> ExitChattingRoom(){

        Map<String, String> map = findCookie();

        if(map == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        String roomNumber = map.get("roomNumber");
        String nickname = map.get("nickname");

        // 방목록에서 방번호에 맞는 유저목록 가져오기
        ChattingRoom chattingRoom = findRoom(roomNumber);
        List<String> users = chattingRoom.getUsers();

        // 닉네임 삭제
        users.remove(nickname);

        // 쿠키에서 닉네임과 방번호 삭제
        deleteCookie();

        // 유저가 한명도 없다면 방 삭제
        if(users.size() == 0) {
            chattingRoomList.remove(chattingRoom);
        }

        return new ResponseEntity<>(chattingRoom, HttpStatus.OK);
    }


    // 참가 중이었던 대화방
    @GetMapping("/chattingRoom")
    public ResponseEntity<?> chattingRoom() {
        // 쿠키에 닉네임과 방번호가 있다면 대화중이던 방이 있던것
        Map<String, String> map = findCookie();

        if(map == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        String roomNumber = map.get("roomNumber");
        String nickname = map.get("nickname");

        ChattingRoom chattingRoom = findRoom(roomNumber);

        if(chattingRoom == null) {
            deleteCookie();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> map2 = new HashMap<>();
            map2.put("chattingRoom", chattingRoom);
            map2.put("myNickname", nickname);

            return new ResponseEntity<>(map2, HttpStatus.OK);
        }
    }



    //	----------------------------------------------------
    // 메세지 컨트롤러

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