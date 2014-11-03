package chapter09_Methods;

import java.util.Scanner;

public class Exr04_elementCounter {

	/**
	 * @param args
	 */
	public static int countNumberInArr(int number, int... numbers) {
		int counter = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == number) {
				counter++;
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		// TODO Count how many times a given number is contained in an array.
		int[] numbers = {1,10,15,7,8,10,25,1,2,2,2,2,4,4,5,10,8,8,78,7};
		System.out.print("Enter number to count: ");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.close();
		
		int count = countNumberInArr(number, numbers);
		
		System.out.printf("The array contains the number %d exactly %d times.", number, count);
	}

}
