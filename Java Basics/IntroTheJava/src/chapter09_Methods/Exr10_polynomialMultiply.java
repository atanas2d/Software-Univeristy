package chapter09_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class Exr10_polynomialMultiply {

	/**
	 * @param args
	 */
	
	
	public static int enterDegree() {	// Enter a number from the keyboard		
		System.out.print("Enter the degree of the polynomial ( between 0 and 10 ): ");
		Scanner input = new Scanner(System.in);		
		while (!input.hasNextInt()) {	// Valdate the type
			System.out.printf("Error! You must enter an integer. %nEnter degree from 0 to 10: ");
			input = new Scanner(System.in);
		}
		int number = input.nextInt();	// get value	
		while ((number < 0)||(number > 10)) {	// Validate the value
			System.out.printf("Error! The number is out of range. %nEnter degree from 0 to 10: ");
			while (!input.hasNextInt()) {	// Valdate the type
				System.out.printf("Error! You must enter an integer. %nEnter degree from 0 to 10: ");
				input = new Scanner(System.in);	
			}
			number = input.nextInt();	// get value
			
		}
		
		return number;
	}	
	
	
	public static void printPolynomial(int params[]) {
		System.out.print("The polynomial you enter looks like: ");
		for (int i = params.length - 1; i >= 0; i-- ) {
			if (params[i] == 0) {
				continue;
			}
			if (i > 1) {
				System.out.printf("%+dx^%d ", params[i],i);
			} else if (i == 1){
				System.out.printf("%+dx ", params[i]);
			} else if (i == 0) {
				System.out.printf("%+d ", params[i]);
			}
			
		}
	}
	
	
	public static int[] multiplicatePolynomials(int[] poly1, int[] poly2) {
		int l1 = poly1.length;
		int l2 = poly2.length;
		int result[];	// initialize the result array
		int temp[][] = new int [2][l1*l2];	//	initialize an auxiliary array for values after the multiplication
											//	the second row will preserve the degree value
		int counter = 0;	// counter of temp[][] elements
		// perform the initial multiplification (brackets disclosure):
		for (int i = 0; i < poly1.length; i++) {	
			for (int j = 0; j < poly2.length; j++) {
				temp[0][counter] = poly1[i]*poly2[j];	// get the parameter value
				temp[1][counter] = i + j;	// get the degree value
				counter++;	
			}			 
		}
		// sum the parameters for equal degrees after bracket disclosuer (in a new array):
		counter = 0;
		int tempFinal[] = new int[l1+l2];
		for (int i = 0; i < temp[0].length; i++) {	
			if (counter > temp[1][i]) {				
				continue;
			} else {
				tempFinal[counter] = temp[0][i];
				for (int j = i + 1; j < temp[0].length; j++) {
					if (temp[1][j] == counter) {
						tempFinal[counter] += temp[0][j];
					}
				}
				counter++;
			}
			if (counter == tempFinal.length) {
				break;
			}
		}
		
		result = tempFinal;
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Multiply Polynomials
		//	Enter the first polynomial:
		System.out.printf("You are about to enter the first polynomial of the multiplication.\n");		
		int degree1 = enterDegree();	// get the degree		
		int[] params1 = new int[degree1 + 1];	// initialize array for the parameters of the 1st polynomial				
		for (int i = params1.length - 1; i >=0; i-- ) {	// get the values of the parameteres
			System.out.printf("Enter a parameter for the degree of %d: ",i);
			Scanner input = new Scanner(System.in);	
			while (!input.hasNextInt()) {	// Valdate the type
				System.out.printf("Error: You must enter an integer. " +
						"\nEnter a parameter for the degree of %d: ",i);
				input = new Scanner(System.in);
			}
			params1[i] = input.nextInt();
		}
		//	Print the polynomial:
		printPolynomial(params1);
		//	Enter the second polynomial:
		System.out.printf("\nNow you are about to enter the second polynomial of the multiplication.\n");		
		int degree2 = enterDegree();	// get the degree		
		int[] params2 = new int[degree2 + 1];	// initialize array for the parameters of the 1st polynomial				
		for (int i = params2.length - 1; i >=0; i-- ) {	// get the values of the parameteres
			System.out.printf("Enter a parameter for the degree of %d: ",i);
			Scanner input = new Scanner(System.in);	
			while (!input.hasNextInt()) {	// Valdate the type
				System.out.printf("Error: You must enter an integer. " +
						"\nEnter a parameter for the degree of %d: ",i);
				input = new Scanner(System.in);
			}
			params2[i] = input.nextInt();
		}
		//	Print the polynomial:
		printPolynomial(params2);
		// Multiplicate the polynomials:
		int[] resultPolynomial = multiplicatePolynomials(params1, params2);
		// Print the result:
		System.out.printf("\nThe result of the multiplication looks like: ");
		printPolynomial(resultPolynomial);	
	}

}
