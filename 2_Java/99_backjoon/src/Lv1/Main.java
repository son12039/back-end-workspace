package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0 ; i<9; i++) {
        	for(int j = 0 ; j<9; j++) {
        		int aa = sc.nextint();
        		if(c<aa) {
        			c=
        			a=i+1;
        			b=j+1;
        		}
        	} sc.nextLine();
        }System.out.println(a+ " " +b);
        
    }
}

