package MainPackage;

public class Calculator {

	public static double housevalue (double allowedpayment, double interest, int years) {
		interest = ((interest/12)/100);
		years = years*12;
		return (allowedpayment/interest)*(1-Math.pow(1+interest, -years));
	}
	public static double housepaymentOnly(double income){
		return (income/12)*.18;
	}
	
	public static double housewithdebt(double income, double monthlyDebt){
		return ((income/12)*.36) - monthlyDebt;
	}
	
	public static double allowedPayment(double income, double monthlyDebt){
		return Math.min(housepaymentOnly(income), housewithdebt(income,monthlyDebt));
	}
	
}

	


