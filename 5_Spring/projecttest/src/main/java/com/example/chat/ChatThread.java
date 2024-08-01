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

public class ChatThread extends Thread{
	
	private String name; //접속명
	private BufferedReader br; //읽을 변수
	private PrintWriter pw; // 읽은걸 출력할 변수
	private Socket socket; // 들어올 클라이언트 자리?같은거
	private List<ChatThread> list; // 각 채팅방별 유저리스트
	
	public ChatThread(Socket socket, List<ChatThread> list) throws IOException {
		this.socket = socket;
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		this.br = br;
		this.pw = pw;
		this.name = name;
		this.list = list;
		this.list.add(this);
	}
	
	public void sendMessage(String msg) {
		pw.println(msg);
		pw.flush();
	}
	
	@Override 
	public void run() {
		// 사용자메세지를 읽어서 접속된 다른 클라에게 발송 broadcast
		
		// 현재 스레드 제외 종료자명 발송
		try {
		broadcast(name+" 접속", false);
		
		
		String line = null;
			while((line = br.readLine()) != null) {
				// 나를 포함한 챗스레드에게 발송
				broadcast(name+ " : " + line, true);
			}
		} catch (Exception e) { // 스레드 연결해제
			broadcast(name+" 접속종료", false);
			this.list.remove(this);
		}
	}
	
	private void broadcast(String msg, boolean includeMe) {
		List<ChatThread> chatThreads = new ArrayList<>();
		Collections.copy(chatThreads, this.list);
		
		try {
			for(int i = 0; i< chatThreads.size(); i++) {
				ChatThread ct = chatThreads.get(i);
				if(!includeMe) { // 나 제외일때
					if(ct == this) {
						continue;
					}
				}
				ct.sendMessage(msg);
			}
		} catch (Exception e) {
			
		}
		
	}
}

















