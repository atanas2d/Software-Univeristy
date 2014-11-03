package chapter09_Methods;

import java.util.Scanner;

public class Example3_Months {

	/**
	 * @param args
	 */
		
	public static String getMonthName (int month) {
		String monthName = "";
		switch (month) {
		case 1: 
			monthName = "January";
			break;
		case 2: 
			monthName = "February";
			break;
		case 3: 
			monthName = "Mart";
			break;
		case 4: 
			monthName = "April";
			break;
		case 5: 
			monthName = "May";
			break;
		case 6: 
			monthName = "June";
			break;
		case 7: 
			monthName = "July";
			break;
		case 8: 
			monthName = "August";
			break;
		case 9: 
			monthName = "September";
			break;
		case 10: 
			monthName = "October";
			break;
		case 11: 
			monthName = "November";
			break;
		case 12: 
			monthName = "December";
			break;
		
		default: 
			monthName = "Month.Out.Of.Range";
			break;
		}
		return(monthName);
	}
	
	public static void printPeriod (int firstM, int secondM) {
		int period = secondM - firstM;
		if ( period < 0) {
			period = period + 12;			
		}
		
		System.out.printf("The period between %s and %s is exactly %d months.", 
				getMonthName(firstM), getMonthName(secondM), period);	
	}
	
	public static void main(String[] args) {
		// TODO Print how many months are between X and Y month in the year.
		System.out.print("Enter first month (1-12): ");
		Scanner input = new Scanner(System.in);
		int firstMonth = input.nextInt();
		
		System.out.print("Enter second month (1-12): ");
		int secondMonth = input.nextInt();
		
		input.close();
		
		printPeriod(firstMonth, secondMonth);

	}
}
