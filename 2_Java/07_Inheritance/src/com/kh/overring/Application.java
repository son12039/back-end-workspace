package com.kh.overring;

import com.kh.overring.model.Customer;
import com.kh.overring.model.VIPCustomer;

public class Application {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("김경주");
		Customer customer2 = new Customer("김경주");
		
		System.out.println(customer1 == customer2); // false
		System.out.println(customer1.equals(customer2)); // false -> true
		
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다.
		customer2.setGrade("GOLD");
		customer2.setBonusPoint(10000);
		System.out.printf("%s+님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.\n",
				customer2.getName(),customer2.getGrade(),customer2.calcPrice(10000),customer2.getBonusPoint());
		
		
		VIPCustomer customer3 = new VIPCustomer("김진주");
		VIPCustomer customer4 = new VIPCustomer("김진주");
		System.out.println(customer3.equals(customer4)); // true

		System.out.printf("%s+님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.",
				customer3.getName(),customer3.getGrade(),customer3.calcPrice(10000),customer3.getBonusPoint());
		System.out.println();
		System.err.println();
		
		
	}

}
