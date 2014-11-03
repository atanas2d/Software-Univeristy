package chapter10_Recursion;

import java.util.Scanner;

public class Exr04_the2ndEdition {
	public static String[] words = {"1", "2", "3" };						// Initialize words string array. Arr Length = 3 
	public static int l = words.length;
	public static boolean[] used = new boolean[l];				// Initialize boolean array (default value: false)...
																			 // used is defining strings to be printed in combination		
	
	public static void printCombo() {	// Print the current combination
		System.out.print("( ");
		for (int i = 0; i < l; i++) {
			if (used[i]) {
				System.out.print(words[i]);
				System.out.print(", ");
			}
		}
		System.out.print(" )");
	}
	
	public static void rec(String words[], int k, int wI) {
		if (k == 0) {
			printCombo();
			return;
		}
		if (wI < 0) {
			return;
		}		
		rec(words, k, wI-1);
		used[wI] = true;
		rec(words, k-1, wI-1);
		used[wI] = false;
	}

	public static void main(String[] args) {
		// TODO Enter some strings and ender K - the number of combinations of strings. Print them all.
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the number of combinations (K): ");
		int k = input.nextInt();											// enter K
		for (int i = 0; i <= k; i++) {
			rec(words, i, l - 1);
		}
														
		input.close();
	}
 
}