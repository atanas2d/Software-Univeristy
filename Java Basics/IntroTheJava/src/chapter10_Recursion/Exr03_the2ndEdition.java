package chapter10_Recursion;

import java.util.Scanner;

public class Exr03_the2ndEdition {
	public static String[] words = {"one", "two", "three"};		// Initialize words string array. Arr Length = 3 
	public static String[] result;	// Initialize result arr.
	public static int k1, l = words.length;	// k keeper, l words[] lengths
	
	public static void printCombo() {	// Print the current combination
		System.out.print("( ");
		for (int i = 0; i < result.length; i++) {
			if (result[i] == null) { 
				continue;
			}
			System.out.print(result[i]);
			if (i < result.length - 1) {	// Place comma
				System.out.print(", ");
			}
		}
		System.out.print(" )");
	}
	
	public static void rec(String[] words, int k) {
		
		if (k == 0) {
			printCombo();
		} else {
			for (int i = k1 - k; i < l; i++) {		// perambulate words[] elements
				 result[k1 - k] = words[i];		// result [ 0 + (k1 - k) ] = words[ i ]
				 rec(words, k - 1);
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Enter some strings and ender K - the number of combinations of strings. Print them all.
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the number of combinations (K): ");
		int k = input.nextInt();											// enter K
		
		result = new String[k]; 										// define result[] length 
		k1 = k;															// use k1 for k keeper
		rec(words, k);											// start recursion
		input.close();

	}
 
}
