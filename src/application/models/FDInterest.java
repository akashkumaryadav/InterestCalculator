package application.models;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class FDInterest extends Account{
	String no_of_days;
	int age_of_holder;
	 Map<String,Double> rate_of_interest_general = new Hashtable<String,Double>();
	 Map<String,Double> rate_of_interest_senior= new Hashtable<String,Double>();
	
	static Scanner in = new Scanner(System.in);
	
	
	public Map<String, Double> getRate_of_interest_general() {
		return rate_of_interest_general;
	}

	public Map<String, Double> getRate_of_interest_senior() {
		return rate_of_interest_senior;
	}

	private void initInterest() {
		 rate_of_interest_general.put("7",4.50);
		 rate_of_interest_general.put("15",4.75);
		 rate_of_interest_general.put("30",5.50);
		 rate_of_interest_general.put("45",7.00);
		 rate_of_interest_general.put("61",7.50);
		 rate_of_interest_general.put("184",8.00); 
		 rate_of_interest_senior.put("7",5.00);
		 rate_of_interest_senior.put("15",5.25);
		 rate_of_interest_senior.put("30",6.00);
		 rate_of_interest_senior.put("45",7.50);
		 rate_of_interest_senior.put("61",8.00);
		 rate_of_interest_senior.put("184",8.50);
	}
	
	private boolean isSenior() {
			return (this.age_of_holder>60)?true:false;
	}
	
//	private void getData() {
//		initInterest();
//		System.out.println("Enter the age");
//		this.age_of_holder = in.nextInt();
//		this.isSenior();
//		System.out.println("Enter the maturity period in days");
//		this.no_of_days =  in.next();
//		calcInterest();S
//		
//	}
	
	 public FDInterest(double amount,String country,int age,String no_of_days) {
		 super(amount, country);
		 this.initInterest();
		 this.age_of_holder = age;
		 this.isSenior();
		 this.no_of_days = no_of_days;
	}
	 
	 
	 public  void maturityPeriod() {
		 int nd = Integer.parseInt(this.no_of_days);
		 if( nd >= 7 &&  nd <  15) {
			  this.no_of_days = "7";
		 }else if(nd >= 15 && nd < 30) {
			 this.no_of_days = "15";
		 }else if(nd >= 30 && nd < 45) {
			 this.no_of_days = "30";
		 }else if(nd >= 45 && nd <=  60 ) {
			 this.no_of_days  = "45";
		 }else if(nd >= 61 && nd <=  184 ) {
			 this.no_of_days  = "61";
		 }else if(nd >= 185 && nd <=  366 ) {
			 this.no_of_days  = "185";
		 }
	 }
	
	@Override
	public double calcInterest() {
		double finalamount;
		maturityPeriod();
		if(this.isSenior()) {	
		 finalamount = super.amount + (super.amount * rate_of_interest_senior.get(this.no_of_days) /100);
		}else {
		finalamount = super.amount + (super.amount * rate_of_interest_general.get(this.no_of_days) /100);	
		}
		return finalamount;
	}
}
