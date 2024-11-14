package solution;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		int a = 24;
		int b = 14;
		System.out.println(m.gcd(a,b));
	}

	public void solution() {
		int[] list = {2,6,8,14};
		
	}

	public int gcd(int a, int b) {
        while (b != 0) {
        	System.out.println(a+" : "+b);
            int temp = b;
            b = a % b;
            a = temp;
             
        }
        return a;
    }
	
}
// [2,6,8,14]	168
// [1,2,3]	6




