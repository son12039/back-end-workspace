package Lv1;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		int n = 30,sum = 0,sumnum=1,i = 0,re = 0;
		boolean check = true;
		while(check) {
			i++;
			sumnum = i;
			while(n>=sumnum) {	
				sum+= sumnum;
				if(n==sum) {re++;break;}
				if(n<sum) break;
 				sumnum++;
			}sum=0;
			if(i>=n/2)check=false;
		} System.out.println(re+1);
	}	
}