package Lv1;

import java.util.Scanner;
import java.util.Stack;

public class A{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	Stack<Integer> stack = new Stack<>();
    	stack.push(10);
    	stack.push(30);
    	stack.push(20);

    	System.out.println(stack);
    	System.out.println(stack.empty());
    }

}