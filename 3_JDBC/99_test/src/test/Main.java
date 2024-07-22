package test;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a1 = 0;
		int a2 = 1;
		int a3 = a1+a2;
		for(int i = 0; i<N-1; i++) {
			a3 = a1+a2;
		    a1= a2;
		    a2= a3;
		}
		System.out.println(a3);
		
	}
}
