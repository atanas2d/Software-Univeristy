package chapter09_Methods;

import java.util.Scanner;

public class Exr03_lastDigitPrint {

	/**
	 * @param args
	 */
	public static int getLastDigit(int number) {
		int digit = number;
		while (number/10 > 0) {
			number %= 10;
			digit = number;
		}
		return digit;
	}
	
	public static void printLastDigit(int number) {
		int digit = getLastDigit(number);
		String digitEn = "";
		switch (digit) {
		case 0: 
			digitEn = "Zero"; 
			break;
		case 1: 
			digitEn = "One"; 
			break;
		case 2: 
			digitEn = "Two"; 
			break;
		case 3: 
			digitEn = "Three"; 
			break;
		case 4: 
			digitEn = "Four"; 
			break;
		case 5: 
			digitEn = "Five"; 
			break;
		case 6: 
			digitEn = "Six"; 
			break;
		case 7: 
			digitEn = "Seven"; 
			break;
		case 8: 
			digitEn = "Eight"; 
			break;
		case 9: 
			digitEn = "Nine"; 
			break;
		default: 
			System.out.print("Some Error has occured!"); 
			break;
		}
		System.out.print(digitEn);
		
	}
	
	public static void main(String[] args) {
		// TODO Print the last digit for a given number in english
		System.out.print("Enter number: ");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.close();
		printLastDigit(number);

	}

}
