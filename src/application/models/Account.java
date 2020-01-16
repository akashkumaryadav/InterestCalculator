package application.models;

import java.util.Scanner;

public  abstract class Account {
	double baseinterestrate;
	double amount;
	public abstract double calcInterest();
	
	static Scanner in = new Scanner(System.in);
	private boolean isCitizen(String cit) {
		return cit.equals("India") ? true : false;
	}
	
	public Account(double amount,String country) {
		if(isCitizen(country)) {
			this.baseinterestrate = 0.04;
		}else {
			this.baseinterestrate = 0.06;
		}
		this.amount = amount;
	}
}
