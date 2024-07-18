package test;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sum = 0;
		int[] c= new int[3];
		for(int i =0; i<N; i++) {
			if(i<=2)c[i]=sc.nextInt();
			else {
			int a = (sc.nextInt());
			int min = Math.max(Math.min(c[0], c[1]), c[2]);
			}
		}
		
		System.out.println(sum);
	}
}
