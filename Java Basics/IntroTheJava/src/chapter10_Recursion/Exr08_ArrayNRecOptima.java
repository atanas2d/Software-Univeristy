// Unresolved! 

package chapter10_Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Exr08_ArrayNRecOptima {
	
	public static int arr[] = {1,3,11,6,7,8,2,13,9,5};		// The initial array
	public static int n; 									// The given sum to find 
	
	public static boolean possible (int k, int sum) {
		boolean possible = false;
		
		return possible;
	}

	public static void main(String[] args) {
		// TODO You have an array of integers and N number. Find every subsets of numbers in the array
		// which sum is equal to N. Optimize the program to work with many numbers
		System.out.printf("This program will find every subsets of numbers that gives a sum N.\nEnter N: ");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();	// Enter N	
		System.out.println("Your initial array is: " + Arrays.toString(arr));	// print the array for a visual test 	
		

	}

}
