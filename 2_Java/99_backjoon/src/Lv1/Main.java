package Lv1;

import java.util.*;
public class Main {
    public static void main(String[] z) {
        Scanner sc = new Scanner(System.in);
        int X = Integer.parseInt(sc.nextLine());
        int Y = Integer.parseInt(sc.nextLine());
        int Z = Integer.parseInt(sc.nextLine());   
        if(X+Y+Z==180)
        System.out.println(X==Y&&Y==Z ? "Equilateral" : 
        	X==Y||Y==Z||Z==X ? "Isosceles" : "Scalene");   
        else System.out.println("Error");
        }    
 } 


