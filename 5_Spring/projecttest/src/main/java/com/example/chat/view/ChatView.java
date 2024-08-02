package com.example.chat.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatView {
    private BufferedReader inputReader;

    public ChatView() {
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readInput() throws Exception {
        return inputReader.readLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
