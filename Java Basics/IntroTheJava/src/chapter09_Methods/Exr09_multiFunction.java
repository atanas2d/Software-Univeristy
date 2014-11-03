package chapter09_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class Exr09_multiFunction {

	/**
	 * @param args
	 */
	public static int enterN() {	// Enter a number from the keyboard		
		System.out.print("Enter n ( > 0 ): ");
		Scanner input = new Scanner(System.in);		
		while (!input.hasNextInt()) {	// Valdate the type
			System.out.printf("Error! You must enter an integer. %nEnter n > 0: ");
			input = new Scanner(System.in);
		}
		int number = input.nextInt();		
		while (number < 0) {	// Validate the value
			System.out.printf("Error! The number is out of range. %nEnter n > 0: ");
			while (!input.hasNextInt()) {	// Valdate the type
				System.out.printf("Error! You must enter an integer. %nEnter n > 0: ");
				input = new Scanner(System.in);
			}
			number = input.nextInt();
			
		}
		input.close();
		return number;
	}
	
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
	
	public static void reverseNumber() {
		int number = enterN();
		printReversedNumber(number);		
	}
	
	public static int[] enterSequence() {
		System.out.print("Enter a sequene of integers (at least 1 number). \n" +
				"Use ; or space for delimiter: ");
		Scanner input = new Scanner(System.in);
		String seq = input.nextLine();		
		int l = seq.length();
		int counter = 0;		
		for (int i = 0; i < l; i++) { // Count the integers
			if (Character.isDigit(seq.charAt(i))) {
				counter++;
			}
			while (Character.isDigit(seq.charAt(i))) {
				i++;
				if (i == l) {					
					break;					
				}
			}
						
			if ((i < l)&&( (seq.charAt(i) != ';') && (seq.charAt(i) != ' ') ) ) {
				System.out.printf("Error: Wrong syntax! Enter only integeres delimated by ; or space !\n" +
						"Restart and try again!!!");
				System.out.println();
				int error[] = {0};
				return error;
			} 			
					
		}
		int[] sequence = new int[counter];
		counter = 0;
		for (int i = 0; i < l; i++) { // Get the integers in sequence[]
			int s = 0, e = 0;
			String num = "";
			if (Character.isDigit(seq.charAt(i))) {
				s = i;
				e = i;
				counter++;
			} else {				
				continue;
			}
			while (Character.isDigit(seq.charAt(i))) {
				i++;
				e++;
				if (i == l) {					
					break;					
				}				
			}
			for (int ii = s; ii < e; ii++) {
				num += seq.charAt(ii);
			}
			sequence[counter - 1] = Integer.parseInt(num);
		}
		input.close();
		return sequence;
	}
	
	public static void printAverageNum (int ... numbers) {
		int l = numbers.length;
		int sum = 0, average = 0;
		for (int i = 0; i < l; i++) {
			sum += numbers[i];
		}
		average = sum/l;
		System.out.printf("The average value of that sequence is: %d", average);
	}
	
	public static void findAverage() {
		int[] sequence = enterSequence();
		printAverageNum(sequence);
	}
	
	public static int enterInt() {	// Enter a number from the keyboard			
		Scanner input = new Scanner(System.in);		
		while (!input.hasNextInt()) {	// Valdate the type
			System.out.printf("Error! You must enter an integer. %nEnter n > 0: ");
			input = new Scanner(System.in);
		}
		int number = input.nextInt();		
		return number;
	}
	
	public static void solveEquation() {
		System.out.printf("This program will solve the equation a*x + b = 0.\n" +
				"Enter a: (!=0)");
		int a = enterInt();
		while (a == 0) {	// Validate the value
			System.out.printf("Error! The number is out of range. %nEnter a (!= 0): ");
			Scanner input = new Scanner(System.in); 
			a = input.nextInt();
		}
		System.out.print("Enter b: ");
		int b = enterInt();
		
		double x = 0.0;
		x = (- (float)b)/(float)a;
		System.out.printf("The solution is: %.2f", x);
	}
	
	public static void main(String[] args) {
		// TODO Multifunctional mathematical exercise with three different functions/methods
		System.out.printf("Choose your preferences: \n" +
				"A : Reveres the digits of a number. \n" +
				"B : Find the average value of a sequence. \n" +
				"C : Solve the equation a*x + b = 0. \n" +
				"Enter A, B or C: ");
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		switch (choice) {
		case "A": 
			reverseNumber();
			break;
		case "B": 
			findAverage(); 
			break;
		case "C": 
			solveEquation(); 
			break;
		default: System.out.print("Error: You must enter A, B or C."); break;
		}

	}

}
