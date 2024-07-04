package Lv1;

import java.util.Arrays;
import java.util.Scanner;
public class Snake {
	public static void main(String[]z) {
		int[] start = {1,1};
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		int[] apple = new int[2];
		int[][] apples = new int[k][2];
		for (int i=0; i<k; i++) {
			apples[i][0] = sc.nextInt();
			apples[i][1] = sc.nextInt();
			System.out.println(Arrays.toString(apples[i]));
		}
		int nn = sc.nextInt();
		String[] move = new String[2];
		String[][] moves = new String[nn][2];
		for (int i=0; i<nn; i++) {
			moves[i][0] = sc.next();
			moves[i][1] = sc.next();
		}
		for (int i=0; i<nn; i++) {
			start[0] = start[i]+ Integer.parseInt(moves[i][0]);
			System.out.println(start[0]);
		}
		
	}
}
