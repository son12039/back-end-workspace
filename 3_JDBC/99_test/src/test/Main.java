package test;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(8%6);
		
	}
	
	public static int solution() {
		int a = 1;
		int aa = 1;
        int[] arr = {2,6,8,14};
        for(int i : arr) {
        	if(a%i==0) {
        		a/=i;
        		
        	} else {
        		while (i != 0) {
                    int temp = i;
                    i = a % i;
                    a = temp;
                }
        	}
        }
        return  a;
    }
	
}
// s.pop() : (s.push(c)
//baabaa	1
//cdcd	0