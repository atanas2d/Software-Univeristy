package chapter09_Methods;

import java.util.Scanner;

public class Exr02_getMax {

	/**
	 * @param args
	 */
	public static int getMaxOf2(int a, int b) {
		int max = a;
		if (b > a) {
			max = b;
		}
		return max;
	}
	
	public static int getMaxNumber(int... numbers) {
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			max = getMaxOf2(max,numbers[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("Enter 3 integers delimated by \";\": ");
		Scanner input = new Scanner(System.in).useDelimiter("[;\\s*]+");
		int[] three = {
				input.nextInt(),
				input.nextInt(),
				input.nextInt()
		};
		input.close();
		
		System.out.printf("%d", getMaxNumber(three));
	}

}
