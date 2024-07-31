package com.example.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(7777);
		List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());
		while(true) {
		Socket socket = serverSocket.accept();
		System.out.println("접속 : " +socket);
		
		ChatThread chatThread = new ChatThread(socket, outList);
		chatThread.start();
		}
	}
}


class ChatThread extends Thread {
	
	private Socket socket;
	private List<PrintWriter> outList;
	private PrintWriter out;
	private BufferedReader in;
	
	
	public ChatThread(Socket socket, List<PrintWriter> outList) {
		this.socket = socket;
		this.outList = outList;
	
		try {
			
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outList.add(out); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 소켓값읽어올 객체 지정
		// 소켓값을 쓰기위한 객체읽기 (현재연결된 1개의 클라에게 쓰는 객체)
	}
	
	public void run() {
		 
		String line = null;
		
		try {
			while((line = in.readLine()) != null) {
				for(int i = 0; i<outList.size(); i++) {
					PrintWriter o = outList.get(i);
					o.println(line);
					o.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 접속이 끊어질때
			try {
			outList.remove(out);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
			for(int i = 0; i<outList.size(); i++) {
				PrintWriter o = outList.get(i);
				o.println("client end");
				o.flush();
			}
			
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		// 클라이언트가 보낸 메세지를 읽기
		// 접속된 모든 클라이언트에게 발송 (여러 클라이언트에게 다같이 쓸 객체 생성
	}
}