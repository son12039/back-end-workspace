package Lv1;

import java.util.Scanner;
public class Main {
	public static void main(String[]z) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String sum = "";
		for (int i = 1; i<=n; i++) {
			sum += "*";
			System.out.println(sum);
		}
	}
}