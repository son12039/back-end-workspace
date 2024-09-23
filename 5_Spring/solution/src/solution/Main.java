package solution;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.s();

	}

	public void solution() {
		int[] list = {2,6,8,14};
		
	}
	public void s() {
		for(int i =1; i<=10; i++) {
			i+=3;
			System.out.println(i);
			 
		}
	}
	public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
	
}
// [2,6,8,14]	168
// [1,2,3]	6




