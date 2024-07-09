package Lv1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int count = 0;
        
        for (int i = 1; i <= num; i++) {
            Set<Character> set = new HashSet<>();
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            
            char prevChar = '\0'; // 이전 문자를 기록할 변수
            
            // 중복되지 않는 문자열 생성
            for (int j = 0; j < str.length(); j++) {
                char currentChar = str.charAt(j);
                
                if (currentChar != prevChar) {
                    sb.append(currentChar);
                    prevChar = currentChar;
                }
            }
            
            // 중복 없는 문자열을 set에 추가하고 count 증가
            boolean isNewString = true;
            for (int j = 0; j < sb.length(); j++) {
                isNewString &= set.add(sb.charAt(j));
            }
            if (isNewString) {
                count++;
            }
        }
        
        System.out.println(count);
    }   
}

