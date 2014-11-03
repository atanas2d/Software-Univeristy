package chapter10_Recursion;

import java.util.Scanner;

public class Exr04_StrCombination2 {
	
	public static String words[] = new String[4], result[];	// input and result strings 	
	public static int k , k1, i = 0;					// k - recursion index, k1 - original k keeper
	
	 
	
	public static void printCombo() {						// Print the current combination
		System.out.print("( ");
		for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
				if (i < result.length - 1) {				// Place comma
					System.out.print(", ");
				}
		}
		System.out.print(" )");
	}
	
	public static void printCombos(String[] words, int k) {
		
		
		if ((i == words.length - 1)&&(result[0] == null)) {
			return;
		} else if (result[0] != null) {
			i++;			
		}
	
		if (k == 0) {
			i--;
			printCombo();		
			return;
		}		
		
		for (int index = i; index < words.length; index++  ) {
			
			result[k1 - k] = words[index];			
			printCombos(words, k - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Exercise 4 
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < words.length; i++) {
			System.out.printf("Enter the %d strings. \nEnter string %d: ", words.length, i+1);
			words[i] = input.next();
			System.out.println();
		}
		for (k = 1; k <= words.length; k++) {				
			result = new String[k];
			k1 = k;
			i = 0;
			printCombos(words, k);
		}
		
		input.close();

	}

}
