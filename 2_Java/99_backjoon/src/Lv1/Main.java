package Lv1;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int count = num;
		StringBuilder sb = new StringBuilder();
		for(int i =1; i<=num; i++) {
			char ch = '\0';
			Set<Character> set = new HashSet<>();
			String str = sc.nextLine();
			sb = new StringBuilder();
			for(int j =0; j<str.length(); j++) {
				if(str.charAt(j)!=ch) {
					sb.append(str.charAt(j));
					ch = str.charAt(j);
				} 
			}
			for(int j =0; j<sb.length(); j++) {
				if(!set.add(sb.charAt(j))) {count--;break;}
			}
		} System.out.println(count);
	}	
}

