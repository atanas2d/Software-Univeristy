package chapter09_Methods;

import java.util.Scanner;

public class Exr07_reverseNumber {

	/**
	 * @param args
	 */	
	
	public static void printReversedNumber(int n) {		
		int digits = 1, num = n; 
		while (num/10 > 0) {
			digits++;
			num /= 10;
		}
		num = 0;
		while (digits > 0) {
			num += (int)((n%10)*Math.pow(10, digits-1));
			digits--;
			n /= 10;
		}		
		System.out.print(num);		
	}
	
	public static void main(String[] args) {
		// TODO Use method that returns a number with reversed digits
		Scanner input = new Scanner (System.in);
		int n = input.nextInt();
		printReversedNumber(n);
		input.close();

	}
	
	

}
