package chapter10_Recursion;

import java.util.Scanner;

public class Exr02_VarietyComb2 {
	
	public static int n = 0;
	public static int k, k1 = 0;
	public static int combo[];
	
	public static void printCombo() {	// Print the current combination
		System.out.print("( ");
		for (int i = 0; i < combo.length; i++) {
				System.out.print(combo[i]);
				if (i < combo.length - 1) {	// Place comma
					System.out.print(", ");
				}
		}
		System.out.print(" )");
	}
	
	public static void printCombos(int n, int k) {		
		if (k == 0) {
			printCombo(); 
			return;
		}
		//	Perambulate combos: 
		for (int value = 1; value <= n; value++ ) {
			combo[k1 - k] = value;			
			printCombos(n, k - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Veriety combinations - incuding repetitons. Enter N (number of elements to combine) and
		//	K - number of combinations		
		Scanner input = new Scanner(System.in);		
		System.out.printf("Enter the number of elements (N): ");
		n = input.nextInt();
		System.out.printf("Enter the number of combinations (K): ");
		k = input.nextInt();
		
		combo = new int[k];	// initialize combo length 		
		k1 = k;			
		printCombos(n, k);	// start the recursion
		input.close();

	}

}
