package com.example.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(7777);
		
		List<ChatThread> list = Collections.synchronizedList(new ArrayList<>()); 
		
		while(true) {
			Socket socket = serverSocket.accept(); // 클라이언트접속
			ChatThread chatClient = new ChatThread(socket, list);
			chatClient.start();
		}
		
		
	}
}
