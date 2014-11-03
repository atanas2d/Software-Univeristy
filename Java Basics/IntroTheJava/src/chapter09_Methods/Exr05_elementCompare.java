package chapter09_Methods;

import java.util.Scanner;

public class Exr05_elementCompare {
	
	/**
	 * @param args
	 */
	public static void printElComparision(int index, int... numbers) {
		char leftSign = '`', rightSign = '`';				
		if (index == 0) {
			if (numbers[index] > numbers[index + 1]) {
				rightSign = '>';
			} else if (numbers[index] == numbers[index + 1]) {
				rightSign = '=';
			} else if (numbers[index] < numbers[index + 1]) {
				rightSign = '<';
			}
			System.out.printf("[%d] %c [%d];", numbers[index], rightSign, numbers[index + 1]);
		} else if (index == numbers.length - 1) {
			if (numbers[index] > numbers[index - 1]) {
				leftSign = '<';
			} else if (numbers[index] == numbers[index - 1]) {
				leftSign = '=';
			} else if (numbers[index] < numbers[index - 1]) {
				leftSign = '>';
			}
			System.out.printf("[%d] %c [%d];", numbers[index - 1], leftSign, numbers[index]);
		} else {
			if (numbers[index] > numbers[index + 1]) {
				rightSign = '>';
			} else if (numbers[index] == numbers[index + 1]) {
				rightSign = '=';
			} else if (numbers[index] < numbers[index + 1]) {
				rightSign = '<';
			}
			if (numbers[index] > numbers[index - 1]) {
				leftSign = '<';
			} else if (numbers[index] == numbers[index - 1]) {
				leftSign = '=';
			} else if (numbers[index] < numbers[index - 1]) {
				leftSign = '>';
			}
			System.out.printf("[%d] %c [%d] %c [%d];", numbers[index - 1], leftSign, numbers[index],
					rightSign, numbers[index + 1]);
		}		
	}
	
	public static void main(String[] args) {
		// TODO Compare if the nubmer in an array index is smaller or greater than the elements to the left
		// and to the right
		
		int[] numbers = {1,10,15,7,8,10,25,1,2,2,2,2,4,4,5,10,8,8,78,7};
		
		System.out.printf("Enter an array index from 0 to %d: ", numbers.length - 1);
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		input.close();
		
		printElComparision(index, numbers);
	}

}
