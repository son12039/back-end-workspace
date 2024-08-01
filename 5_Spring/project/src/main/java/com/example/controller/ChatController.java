package com.example.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chat.ChatServer;

@Controller
public class ChatController {
	
	private Socket socket;
    private PrintWriter out;
	
    public ChatController() {
        try {
            socket = new Socket("127.0.0.1", 7777);
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	@GetMapping("/chat")
    public String showChatPage() {
        return "chat";
    }
	@PostMapping("/chat")
    public String sendMessage(@RequestParam String chat) {
        ChatServer chatServer = new ChatServer();
        return "redirect:/chat";
    }
	
}
