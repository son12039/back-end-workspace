package Lv1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         ArrayList<ArrayList<String>> musiclist= new ArrayList();
         while(true){
         ArrayList<String> music= new ArrayList();
		music.add(sc.nextLine());
		music.add(sc.nextLine());
		musiclist.add(music);
		System.out.println(musiclist);

        } 
    }    


