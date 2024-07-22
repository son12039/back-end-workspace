package Lv1;

import java.util.*;

public class Main {
	public static void main(String[] z) {
		int a = test();
         System.out.println(a);
	}
	
	public static int test() {
		int[] n =  {3,3,3,2,2,4};
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i<n.length; i++) {
			if(!arr.contains(n[i])) {
				arr.add(n[i]);
			}
			if(n.length/2==arr.size()) {
				return n.length/2;
			}
		}
		return arr.size();
		
	}
}

