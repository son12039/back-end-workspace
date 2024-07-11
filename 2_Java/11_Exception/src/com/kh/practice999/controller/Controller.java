package com.kh.practice999.controller;

import java.util.ArrayList;

import com.kh.practice999.model.Music;

public class Controller {
    ArrayList<Music> musiclist = new ArrayList<>();
    Music music = new Music();

    public void lastadd(String title, String singer) {
        Music newMusic = new Music(title, singer);
        musiclist.add(newMusic);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Music m : musiclist) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }
}

