package com.kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(60000);
			Socket s = server.accept();
			System.out.println(s.getInetAddress() + " 접속");
			
			// 클라이언트가 보낸 메세지를 받는다
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			// 다시 클라이언트에게 받은 메세지를 보낸다
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			
			String line = null;
			while((line = br.readLine())!= null) {
				System.out.println(s.getInetAddress() + " : 가 보낸 메세지 : " + line);
				pw.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
//    public static void main(String[] args) {
//
//        try {
//            // 1. ServerSocket 생성 - 포트번호 : 60000
//            ServerSocket server = new ServerSocket(60000);
//            System.out.println("Server Ready..");
//
//            // 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴
//            Socket s = server.accept();
//            System.out.println("Client Socket..");
//
//            // 3. 소켓으로부터 스트림 리턴
//            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
//
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                System.out.println("Client가 보낸 메세지 : " + line);
//
//                pw.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Client와의 연결이 끊어졌습니다..");
//            e.printStackTrace();
//        }
//    }
}

