package chapter09_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class Exr08_nFactorial {

	/**
	 * @param args
	 */
	public static int enterN() {	// Enter a number from the keyboard		
		System.out.print("Enter n [1:100]: ");
		Scanner input = new Scanner(System.in);
		
		while (!input.hasNextInt()) {	// Valdate the type
			System.out.printf("Error! You must enter an integer. %nEnter n [1:100]: ");
			input = new Scanner(System.in);
		}
		int number = input.nextInt();		
		while (number < 1 || number > 100) {	// Validate the value
			System.out.printf("Error! The number is out of range. %nEnter n [1:100]: ");
			number = input.nextInt();			
		}
		input.close();
		return number;
	}
	public static int getDigitsN(int number) { // Returns digits number for a given number
		int digits = 1;
		while (number / 10 > 0) {
			digits ++;
			number /= 10;
		}
		return digits;
	}
	
	public static int[] convertNumToArr(int num) { // Converting a given number to an array of digits (reversed)
		int[] number = new int[getDigitsN(num)];
		for (int i = 0; i < number.length; i++) {
			number[i] = num%10;
			num /= 10;
		}
		return number;
	}	
	
	public static int[] multiplyManual(int[] m1, int[] m2) { // Manual multiplication in arrays
		int[] result = new int[160];
		int length = getNFactorialLength(m2);
		int[][] multis = new int[3][160]; // initialize the helping Multipliers
		for (int ii = 0; ii < m1.length; ii++ ) {	// Perform multiplication			
			int reminder = 0;
			int hMi=0; // Declare hM index	
			
			for (int i = 0; i < length; i ++ ) { // Digits multiplication
				if (ii > 0 && hMi == 0) {					
					hMi++;					
				}
				int multi = m1[ii] * m2[i];	//multiply the digits
				
				multis[ii][hMi] = multi + reminder;	// record the result digit in the helping Multiplier
				reminder = multis[ii][hMi]/10; 	// record the reminder
				multis[ii][hMi] %= 10;
				hMi++;				
			}
			
			multis[ii][length++ ] = reminder; // Write down the last reminder
		
			
		}
		// Sum the helping Multipliers:
		for (int i = 0; i < 3; i++) {
			int reminder = 0;			
			for (int ii = 0; ii < length ; ii++) {				
				result[ii] = result[ii] + multis[i][ii] + reminder; // Get the whole value for result[ii]
				reminder = result[ii]/10; // Get the reminder
				result[ii] %= 10; // Get the digit value
			}			
			result[length] = reminder; // Write down the last reminder
			
		}
		
		return result;
	}
	
	public static int getNFactorialLength (int[] number) {	// Get nFactorial[] real length (deafult:160)
		int length = 0;
		for (int i = number.length - 1; number[i] == 0 && i > 0; i--) {
			length++;
			
		}
		length = 159 - length;
		return length + 1;
	}
	
	public static void printNFactorial(int number) { // Calculate nFactorial in 160 digits number array
		int[] nFactorial = new int[160];
		nFactorial[0] = 1;
		for (int i = 1; i <= number; i++) {
			int[] multiplier = convertNumToArr(i); // reversed 
			nFactorial = multiplyManual(multiplier, nFactorial);			
		}				
		// Reversing nFactorial - prepearing for a final print
		int length = getNFactorialLength(nFactorial);
		int[] nFFinal = new int[length + 1];
		for (int i = length, ii = 0; i >= 0; i--, ii++) {
			nFFinal[ii] = nFactorial[i];
		}
		
		System.out.print(Arrays.toString(nFFinal));
	}
	
	public static void main(String[] args) {
		// TODO Print n! (n is in interval [1:100]) ((Works 1:20.. :( ))
		int n = enterN();		
		printNFactorial(n);	
	}

}
