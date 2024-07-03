package Lv1;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = Integer.parseInt(sc.nextLine());
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.printf("%d\n%d\n%d\n%d",num2%10*num1,(num2/10-(num2/100*10))*num1,num2/100*num1,num1*num2);	
	}
}
