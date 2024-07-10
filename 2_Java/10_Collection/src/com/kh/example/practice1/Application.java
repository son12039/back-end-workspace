package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;

public class Application {

	public static void main(String[] z) {
		ArrayList<Integer> arr = new ArrayList(); // 정해진 거
		ArrayList<Integer> arr2 = new ArrayList(); // 내가 뽑은 번호
		int count = 0;
		for (int i = 0; i < 6; i++) {
			arr.add((int) (Math.random() * 45 + 1));
		}
		Collections.sort(arr);
		while (!arr.equals(arr2)) {
			count++;
			arr2.clear();
			for (int i = 0; i < 6; i++) {
				arr2.add((int) (Math.random() * 45 + 1));
			}
			Collections.sort(arr2);
			System.out.println("로또 번호 : " + arr);
			System.out.println("내 번호 : " + arr2);
		}
		System.out.println(count);
	}
}

