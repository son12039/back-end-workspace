package com.kh.practice999.controller;

import java.util.ArrayList;
import java.util.Comparator;

import com.kh.practice999.model.Music;

public class Controller {
    ArrayList<Music> musiclist = new ArrayList<>();
    Music music = new Music();
    
    
    
    public void lastadd(String title, String singer) {
        Music addMusic = new Music(title, singer);
        musiclist.add(musiclist.size(),addMusic);
    }
    
    public void firstadd(String title, String singer) {
    	Music addMusic = new Music(title, singer);
        musiclist.add(0, addMusic);
    }

    public ArrayList<Music> Allprint() {       
        return musiclist;
    }
    
    public Music search(String title) {
    	for(Music search : musiclist) {
    		if(search.getTitle().contains(title))return search;
    	}
		return null;
    }
    
    public Music delete(String title) {
    	 Music deleteMusic = null;
    	for (Music music : musiclist) {
            if (music.getTitle().equals(title)) {
                deleteMusic = music;
                break;
            }
        }
        if (deleteMusic != null) {
            musiclist.remove(deleteMusic);
        }
		return deleteMusic;
    }
    
    public Music rewrite(String rewritett,String title,String singer) {
    	 Music beforeMusic = null;
    	for(Music rewritetitle : musiclist) {
    		if(rewritetitle.getTitle().equals(rewritett)) {
    			beforeMusic = new Music(rewritetitle.getTitle(),rewritetitle.getSinger());
    			rewritetitle.setSinger(singer);
    			rewritetitle.setTitle(title);
    			break;
    		}

    	}
		return beforeMusic;    	
    }
    
    public void singerdownset() {
        musiclist.sort(new Comparator<Music>() {  	
            @Override
            public int compare(Music m1, Music m2) {
                return m2.getSinger().compareTo(m1.getSinger());
            	}
        	}
       );
    }
    
    public void singerupset() {
        musiclist.sort(new Comparator<Music>() {  	
            @Override
            public int compare(Music m1, Music m2) {
                return m1.getSinger().compareTo(m2.getSinger());
            	}
        	}
       );
    }
}

