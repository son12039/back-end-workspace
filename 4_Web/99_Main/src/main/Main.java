package main;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int c = Integer.parseInt(sc.nextLine());
		int n0 = Integer.parseInt(sc.nextLine());
		System.out.println(n*n0 + m <= c*n0 ? 1 : 0);
	}
}
