package Lv1;

import java.util.*;

public class Main {
	public static void main(String[] z) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int sum = 0;
		for(int i= 0; i<n; i++) {
			arr.add(sc.nextInt());			
		}
		for(int i= 0; i<n; i++) {
			for(int j= 0; j<n; j++) {
				for(int k= 0; k<n; k++) {
					if(arr.get(i)+arr.get(j)+arr.get(k)<=m&&arr.get(i)+arr.get(j)+arr.get(k)>sum)
						sum = arr.get(i)+arr.get(j)+arr.get(k);
				}
			}
		}
		System.out.println(sum);
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));System.out.println(arr.get(2));
		
		
	}
}

// 15 || 5 4 2 1