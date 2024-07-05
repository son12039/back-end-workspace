package com.kh.example.practice2.model;

import java.util.Scanner;

public class Snack {
	Scanner sc = new Scanner(System.in);
	private String kind,name,flavor;
	private int numOf,price;

	public void Snack(String kind,String name,String flavor,int numOf,int price) {
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}
	public Snack() {}
 
	@Override
	public String toString() {
		return "Snack [kind=" + kind + ", name=" + name + ", flavor=" + flavor + ", numOf=" + numOf + ", price=" + price
				+ "]";
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		System.out.print("종류 : ");
		kind = sc.nextLine();
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.print("이름 : ");
		name = sc.nextLine();
		this.name = name;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		System.out.print("맛 : ");
		flavor = sc.nextLine();
		this.flavor = flavor;
	}
	public int getNumOf() {
		return numOf;
	}
	public void setNumOf(int numOf) {
		System.out.print("개수 : ");
		numOf = Integer.parseInt(sc.nextLine());
		this.numOf = numOf;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		System.out.print("가격 : ");
		price = Integer.parseInt(sc.nextLine());
		this.price = price;
	};
}
