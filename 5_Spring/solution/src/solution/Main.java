package solution;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
//		m.solution();
		m.gcd(8, 6);
	}

	public void solution() {
		int[] list = {2,6,8,14};
		int result = 1;
		int divides = 1;
		for(int i :list) {
			int a = i/divides;
			result*=a;
			divides*=a;
			System.out.println(result);
		}
	}
	public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
            System.out.println(a+" : "+b);
        }
        return a;
    }
	
}
// [2,6,8,14]	168
// [1,2,3]	6




