package com.kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattClient {
	
	public static void main(String[] args) {
	
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			Socket s = new Socket(ip, 60000);
			
			
			// 키보드로 입력받은 데이터를 읽어서 서버한테 보낸다
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			
			// 다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력한다.
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true) {
				pw.println(br.readLine());
				System.out.println("내가 보낸 메세지 : " + br2.readLine());
			}
		} catch (IOException e) {
			
		}
		
	}

}

