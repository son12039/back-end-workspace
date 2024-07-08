package Lv1;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int[][] a = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		int[][] aa = new int[5][5];
		for(int i = 0 ;i<a.length; i++) {
		 System.out.println(Arrays.toString(a[i]));
		 System.out.println(Arrays.toString(aa[i]));
		 }
	}
}
// [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]] 
// {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}}