package chapter10_Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Exr07_ArrayNRec {
	// input arr : 
	public static int[] arr = {1,2,3,44,11,5,7,22,8,14};					// ,8,16,77,201,3,4,5,111,9,4,13,2
	public static int n, l = arr.length;			// n - sum value to find, k - recursion index, k1 - original k keeper
	public static boolean [] used = new boolean[l];						// result arr
	
	
	public static void printSubset() {	// Print the chosen subset
		System.out.print("( ");
		for (int i = 0; i < l; i++) {
			if (used[i]) {
				System.out.print(arr[i]);
				boolean last = true;			// check if the element is last to decide whether to place comma
				for (int j = i + 1; j < l; j++) {
					if (used[j] == true) {
						last = false;
					}					
				}
				if (!last) {
					System.out.print(", ");		
				}
				
			}
		}
		System.out.print(" ) ");
	}	
	
	
	
	public static void findSum(int[] arr, int k, int aI) {		// the array[], k, array index (aI)		
		if (k == 0) {
			int sum = 0;
			for (int i = 0; i < l; i++) {
				if (used[i]) {
					sum += arr[i];
				}
			}			
			if (sum == n) {
				printSubset();				
			}			
			
			return;
		}
		if (aI < 0) {
			return;
		}		
		findSum(arr, k, aI-1);
		used[aI] = true;
		findSum(arr, k-1, aI-1);
		used[aI] = false;		
	}

	public static void main(String[] args) {
		// TODO You have an array of integers and N number. Find every subsets of numbers in the array
		// with sum that equals N.		
		System.out.printf("This program will find every subsets of numbers that gives a sum N.\nEnter N: ");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();	// Enter N	
		System.out.println("Your initial array is: " + Arrays.toString(arr));	// print the array for a visual test 		
						
		for (int i = 0; i <= l; i++) {	// start rec for every number of combinations from 0 to array length. This will perambulate every possible combination
			findSum(arr, i, l - 1);
		}			
		input.close();
	}

}
