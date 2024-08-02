package com.example.chat.controller;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.example.chat.ChatClientHandler;
import com.example.chat.model.ChatModel;

public class ChatServerController {
    private ChatModel chatmodel;

    public ChatServerController() throws Exception {
        ServerSocket serverSocket = new ServerSocket(7777);
        chatmodel = new ChatModel();

        while (true) {
            Socket socket = serverSocket.accept();
            new ChatClientHandler(socket, chatmodel).start();
        }
    }
}
