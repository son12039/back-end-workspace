package com.ChattingTest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private String message;
    private String nickname;
    private Date date;

    Message(){ // 쓸 때마다 현재시각으로 변경
        date = new Date();
    }
}