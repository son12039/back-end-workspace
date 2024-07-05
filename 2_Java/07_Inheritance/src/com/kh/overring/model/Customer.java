package com.kh.overring.model;

import java.util.Objects;

import com.kh.inheritance.parent.Product;

/*
 * 클래스 간의 관계 : 상속 vs 포함
 * - 상속 관계 : ~은 ~이다. (is - a)
 * - 포함 관계 : ~은 ~을 가지고 있다. (has - a)
 * - 자바는 단일상속만 허용
 * - 클래스 간의 관계를 많이 맺을수록 재사용을 높이고 관리하기 쉽게 한다.
 * */
public class Customer {
	
	protected String name; // 고객 이름
	protected String grade; // 고객 등급
	protected int BonusPoint; // 보너스 포인트
	protected double bonusRatio; // 보너스 적립 비율
	
	Product product; // 포함관계
	
	public Customer(String name) {
		this.name = name;
		this.grade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	
	@Override // <- 어노테이션! '이 메서드는 재정의된 메서드이다.'라고 명확히 알려주는 역할
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;
		return this.name == c.name;
	}

	public int calcPrice(int price) {
		this.bonusRatio += price * bonusRatio; // 보너스 포인트 계산!

		return price;
	}

	@Override
	public String toString() {
		return name+"님의 등급은" +grade+"이며, 지불해야 하는 금액은 "+(bonusRatio)+
					"원이며, 적립된 포인트는 "+bonusRatio+"점입니다.";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBonusPoint() {
		return BonusPoint;
	}

	public void setBonusPoint(int bounsPoint) {
		this.BonusPoint = bounsPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bounsRatio) {
		this.bonusRatio = bounsRatio;
	}
	
	
}
