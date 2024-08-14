package solution;

public class Solution {
	
	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
//		solution(arr);
		System.out.println(gcd(14,10));
	}
	
	public static int solution(int[] arr) {
		int a = 1;
		for(int i : arr) {
			int b = a;
			System.out.println(i);
		}
		 return 1;
   }
	
	public static int gcd(int a, int b) {
        while (b != 0) {
        	System.out.println(a+"  " + b);
            int temp = b;
            b = a % b;
            a = temp;
             
        }
        return a;
    }

    // 두 수의 최소공배수를 구하는 메서드
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b)); // (a * b) / gcd(a, b)로도 가능하지만, 오버플로우를 방지하기 위해 이 방법이 더 안전합니다.
    }
    
    public static int test(int a, int b) {
    	int aa = b;
       b = a%b;
       a= aa;
        return a;
    }

    
    
    
}