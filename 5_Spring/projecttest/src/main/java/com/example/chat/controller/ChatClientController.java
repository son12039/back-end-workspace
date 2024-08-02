package com.example.chat.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import com.example.chat.view.ChatView;

public class ChatClientController {
    private ChatView view;
    private BufferedReader serverInput;
    private PrintWriter serverOutput;

    public ChatClientController(String name) throws Exception {
        Socket socket = new Socket("127.0.0.1", 7777);
        serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        serverOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        view = new ChatView();

        serverOutput.println(name);

        // Handle server messages in a separate thread
        new Thread(() -> {
            try {
                String line;
                while ((line = serverInput.readLine()) != null) {
                    view.printMessage(line);
                }
            } catch (Exception e) {
                view.printMessage("접속이 끊겼소");
            }
        }).start();

        // Read input from the user and send to server
        String userInput;
        while ((userInput = view.readInput()) != null) {
            if ("/end".equals(userInput)) {
                break;
            }
            serverOutput.println(userInput);
        }

        socket.close();
    }
}
