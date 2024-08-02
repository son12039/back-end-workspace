package com.example.chat.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.chat.ChatClientHandler;

public class ChatModel {
    private List<ChatClientHandler> clients;

    public ChatModel() {
        clients = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized void addClient(ChatClientHandler client) {
        clients.add(client);
        broadcast(client.getName() + " 들어왔소", false);
    }

    public synchronized void removeClient(ChatClientHandler client) {
        clients.remove(client);
        broadcast(client.getName() + " 나가버렸소", false);
    }

    public synchronized void broadcast(String message, boolean includeSelf) {
        for (ChatClientHandler client : clients) {
            if (includeSelf || !client.isSelf()) {
                client.sendMessage(message);
            }
        }
    }
}

