package com.example.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatThread extends Thread {
    
    private String name; //접속명
    private BufferedReader br; //읽을 변수
    private PrintWriter pw; // 읽은걸 출력할 변수
    private Socket socket; // 들어올 클라이언트 자리?같은거
    //private List<ChatThread> list; // 각 채팅방별 유저리스트
    private List<ChatThread> list = Collections.synchronizedList(new ArrayList<>()); 
    
    public ChatThread(Socket socket) {
        this.socket = socket;
        try {
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        this.list.add(this);
    }
    
    public void sendMessage(String msg) {
    	System.out.println(msg);
        pw.println(msg);
        pw.flush();
    }
    
    @Override 
    public void run() {
    	System.out.println("???");
        try {
            // 사용자 이름 읽기
            name = br.readLine();
            // 새로운 사용자 접속 메시지 방송
            broadcast(name + " 접속", true);
            
            String line;
            while ((line = br.readLine()) != null) {
                // 사용자 메시지 방송
                broadcast(name + " : " + line, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 연결 종료 처리
            broadcast(name + " 접속종료", false);
            list.remove(this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void broadcast(String msg, boolean includeMe) {
    	System.out.println("broadcast!");
        try {
            // 리스트를 직접 순회하여 메시지 전송
            synchronized (list) {
                for (ChatThread ct : list) {
                    if (!includeMe && ct == this) {
                        continue;
                    }
                    ct.sendMessage(msg);
                }
            }
        } catch (Exception e) {
            System.out.println("오류가 났소");
        }
    }

}


















