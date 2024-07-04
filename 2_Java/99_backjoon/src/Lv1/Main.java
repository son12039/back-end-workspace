package Lv1;

import java.util.Scanner;
import java.util.Stack;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int num = sc.nextInt();
		for(int i = 0; i<=num; i++) {	
			String str = sc.nextLine();		
			switch (str.split(" ")[0]) {
	    	case "push" : stack.push(Integer.parseInt(str.split(" ")[1]));
			break;
			case "top" : if(stack.size()==0) {System.out.println(-1);}
						else{System.out.println(stack.peek());}
			break;
			case "empty" : System.out.println(stack.empty() ? 1 : 0);
			break;
			case "size" : if(stack.size()==0) {System.out.println(0);}
						  else{System.out.println(stack.size());}
			break;
			case "pop" : if(stack.size()==0) {System.out.println(-1);}
						else{System.out.println(stack.pop());}
			break;
			}
		}
	}
}