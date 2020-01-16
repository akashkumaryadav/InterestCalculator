package application.models;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class RDInterest extends Account{
	
	public RDInterest(double amount, String country) {
		super(amount, country);
		// TODO Auto-generated constructor stub
	}

	String no_of_months;
	int age_of_holder;
	Map<String,Double> rate_of_interest_general = new Hashtable<String,Double>();
	Map<String,Double> rate_of_interest_senior= new Hashtable<String,Double>();
	
	static Scanner in = new Scanner(System.in);
	private void initInterest() {
		 rate_of_interest_general.put("6",7.50);
		 rate_of_interest_general.put("9",7.75);
		 rate_of_interest_general.put("12",8.00);
		 rate_of_interest_general.put("15",8.25);
		 rate_of_interest_general.put("18",8.50);
		 rate_of_interest_general.put("21",8.75); 
		 rate_of_interest_senior.put("6",8.00);
		 rate_of_interest_senior.put("9",8.25);
		 rate_of_interest_senior.put("12",8.50);
		 rate_of_interest_senior.put("15",8.75);
		 rate_of_interest_senior.put("18",9.00);
		 rate_of_interest_senior.put("21",9.25);
	}
	
	private boolean isSenior() {
			return (this.age_of_holder>60)?true:false;
	}
	
//	private void getData() {
//		initInterest();
//		System.out.println("Enter the age");
//		this.age_of_holder = in.nextInt();
//		this.isSenior();
//		System.out.println("Enter the maturity period");
//		this.no_of_months =  in.next();
//		calcInterest();
//		
//	}
//	
	 public RDInterest(double amount,String country,int age,String maturity) {
		 super(amount,country);
		 this.initInterest();
		 this.age_of_holder = age;
		 this.isSenior();
		 this.no_of_months = maturity;
	}
	
	public Map<String, Double> getRate_of_interest_general() {
		return rate_of_interest_general;
	}

	public Map<String, Double> getRate_of_interest_senior() {
		return rate_of_interest_senior;
	}

	@Override
	public double calcInterest() {
		double finalamount;
		if(this.isSenior()) {
		 finalamount = super.amount + (super.amount * rate_of_interest_senior.get(this.no_of_months) /100);
		}else {
		finalamount = super.amount + (super.amount * rate_of_interest_general.get(this.no_of_months) /100);	
		}
		return finalamount;
	}

}
