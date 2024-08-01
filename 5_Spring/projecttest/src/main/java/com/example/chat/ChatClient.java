package com.example.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) throws Exception{
		if(args.length != 1) {
			System.out.println("테스트");
			return;
		}
		String name = args[0];
		Socket socket = new Socket("127.0.0.1", 7777);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		pw.println(name);
		pw.flush();
		
		// 사용자한테 받은 메세지 서버에 전송
		InputThread inputThread = new InputThread(br);
		inputThread.start();
		 
		// 서버에서 온 메세지 출력
		try {
			String line = null;
			while((line = br.readLine()) != null) {
				if("/end".equals(line))
					break;
				pw.println(line);
				pw.flush();
			}
		} catch (Exception e) {
			System.out.println("한명 접속 끊김11");
		}
		
		socket.close();
	}

}

class InputThread extends Thread{
	BufferedReader br;
	public InputThread(BufferedReader br) {
		this.br = br;
	}
	
	@Override
	public void run() {
		
		try {
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("한명 접속 끊김");
		}
		
	}
	
		
	
	
}



