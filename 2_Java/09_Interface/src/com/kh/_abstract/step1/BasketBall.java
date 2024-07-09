package com.kh._abstract.step1;

public class BasketBall extends Sports{

	public BasketBall(int numberOfplayers) {
		super(numberOfplayers);
	}

	@Override
	public void rule() {
		System.out.println("BastketBall의 선수의 수는 " + 
				this.numberOfplayers + "명, 공을 던져서 링에 넣어야 한다.");
	}

}
	