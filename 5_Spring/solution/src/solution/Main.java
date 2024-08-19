package solution;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
			System.out.println(a);
	}

	public static void solution(int[] a) {

	}

}

//public static int[] solution(int[] a) {
//
//	int x = 0;
//	int y = 0;
//	int z = 0;
//	for (int i = 0; i < a.length; i++) {
//		if (a[i] % 5 == (i + 1) % 5)
//			x++;
//		if (a[i] == 2 && i % 2 == 0) {
//			y++;
//		}
//		if ((i % 8 == 1 && a[i] == 1) || (i % 8 == 3 && a[i] == 3) || (i % 8 == 5 && a[i] == 4)
//				|| (i % 8 == 7 && a[i] == 5)) {
//			y++;
//		}
//		if ((a[i] == 3 && i % 10 <= 1)) {
//			z++;
//			System.out.println("엥? " + i);
//		}
//		else if ((a[i] == 1 && i % 10 <= 3)) {
//			z++;System.out.println("엥? " + i);
//		}
//		else if ((a[i] == 2 && i % 10 <= 5)) {
//			z++;System.out.println("엥? " + i);
//		}
//		else if ((a[i] == 4 && i % 10 <= 7)) {
//			z++;System.out.println("엥? " + i);
//		}
//		else if ((a[i] == 5 && i % 10 <= 9)) {
//			z++;System.out.println("엥? " + i);
//		}
//	}
//	return new int[] { x, y, z };
//}