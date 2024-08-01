package com.example.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java com.example.chat.ChatClient <name>");
            return;
        }

        String name = args[0];
        Socket socket = new Socket("127.0.0.1", 7777);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Connected to the chat server.");

        Thread readThread = new Thread(() -> {
            try {
                String serverMessage;
                while ((serverMessage = in.readLine()) != null) {
                    System.out.println(serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        readThread.start();

        String userMessage;
        while ((userMessage = keyboard.readLine()) != null) {
            out.println(name + " : " + userMessage);
        }

        socket.close();
    }
}

