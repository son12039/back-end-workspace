package com.example.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080); // 포트 8080에서 대기
        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected: " + socket);

            ChatThread chatThread = new ChatThread(socket, outList);
            chatThread.start();
        }
    }
}

class ChatThread extends Thread {
    private Socket socket;
    private List<PrintWriter> outList;
    private PrintWriter out;
    private BufferedReader in;

    public ChatThread(Socket socket, List<PrintWriter> outList) {
        this.socket = socket;
        this.outList = outList;
        try {
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outList.add(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = in.readLine()) != null) {
                synchronized (outList) {
                    for (PrintWriter writer : outList) {
                        writer.println(line);
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outList.remove(out);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

