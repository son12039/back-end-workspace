package com.example.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import com.example.chat.model.ChatModel;

public class ChatClientHandler extends Thread {
    private Socket socket;
    private ChatModel chatmodel;
    private BufferedReader in;
    private PrintWriter out;
    private String name;

    public ChatClientHandler(Socket socket, ChatModel chatmodel) throws Exception {
        this.socket = socket;
        this.chatmodel = chatmodel;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }
    
    public boolean isSelf() {
        return name.equals(name);
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    @Override
    public void run() {
        try {
            name = in.readLine();
            chatmodel.addClient(this);

            String message;
            while ((message = in.readLine()) != null) {
            	chatmodel.broadcast(name + " : " + message, false);
            }
        } catch (Exception e) {
            System.out.println("오류가 났소: " + e.getMessage());
        } finally {
        	chatmodel.removeClient(this);
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("닫혔소");
            }
        }
    }
}
