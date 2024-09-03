package com.kh.test.websocket;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.CloseStatus;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MoveWebSocketHandler extends TextWebSocketHandler {

    // Store WebSocket sessions
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private int clientCounter = 1;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Assign a unique ID to each new client
        String clientId = "ch" + clientCounter++;
        sessions.put(clientId, session);

        // Notify the new client of their ID and initial state
        String initialStateMessage = String.format(
            "{\"type\": \"initialize\", \"id\": \"%s\", \"top\": 0, \"left\": 0, \"clients\": [%s]}",
            clientId,
            String.join(",", sessions.keySet().stream().map(id -> String.format("{\"id\": \"%s\"}", id)).toArray(String[]::new))
        );
        session.sendMessage(new TextMessage(initialStateMessage));

        // Notify all other clients about the new client
        for (WebSocketSession s : sessions.values()) {
            if (s != session) {
                String newClientMessage = String.format(
                    "{\"type\": \"newClient\", \"id\": \"%s\"}",
                    clientId
                );
                s.sendMessage(new TextMessage(newClientMessage));
            }
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        // Broadcast the message to all connected clients
        for (WebSocketSession s : sessions.values()) {
            if (s != session) {
                s.sendMessage(message);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Find the ID of the closed session and remove it
        String closedClientId = null;
        for (Map.Entry<String, WebSocketSession> entry : sessions.entrySet()) {
            if (entry.getValue().equals(session)) {
                closedClientId = entry.getKey();
                break;
            }
        }
        if (closedClientId != null) {
            sessions.remove(closedClientId);

            // Notify all remaining clients about the closed client
            String clientLeftMessage = String.format(
                "{\"type\": \"clientLeft\", \"id\": \"%s\"}",
                closedClientId
            );
            for (WebSocketSession s : sessions.values()) {
                s.sendMessage(new TextMessage(clientLeftMessage));
            }
        }
    }
}
