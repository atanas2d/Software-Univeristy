package chapter10_Recursion;

import java.util.Scanner;

public class Exr06_Permutations {
	public static int[] perm;	// an array for current permutation record
	public static int num;
	
	public static void printPerm() {	// printing a permutation
		int i;
		System.out.print("(");
		for (i = 0; i < perm.length; i++) {			
			System.out.print(perm[i]);
			if (i != perm.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print(")");
	}
	
	public static void perm (int k) {	// the permutation recursion
		int i,t;	// index
		if (k == 0) {
			printPerm();
			return;		
		}
		for (i = 0; i <= k ; i++) {
			t = perm[i];
			perm[i] = perm[k];
			perm[k] = t;	// perm[i]  <->  perm[k]
			perm(k - 1);		// go deeper to the recursion ;)
			t = perm[i];
			perm[i] = perm[k];
			perm[k] = t;			
		}
				
	}
	
	public static void main (String[] args) {
		// TODO Permutation of a variety of numbers from 1 to n
		System.out.println("This program will print permutations from 1 to N. Enter N: ");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();	// N input			
		perm = new int[num];		// initialize perm[] array length		
		for (int i = 0; i < num; i++) {	// fulfill perm[] for initial use - [1,2,..,n]
			perm[i] = i + 1;			
		}
		perm(num - 1);					// start the recursion
		input.close();
	}
}
