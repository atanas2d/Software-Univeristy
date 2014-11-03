package chapter11_ObjectsCreatingAndUsing;

import java.util.*;

public class Examples2 {

	public static void main(String[] args) {
		// Examples of Objects using and creating, Second edition
		
		// System test for how milliseconds the system will make some operations
//		int sum = 0;
//		long startTime = System.currentTimeMillis();
//		
//		// The code fragment to be tested
//		for (int i = 0; i < 10000000; i++) {
//			sum++;
//		}
//		
//		long endTime = System.currentTimeMillis();
//		System.out.printf("The time elapsed is %f sec.", (endTime - startTime)/1000.0);
		
		
		// math.random example
		Random randy7 = new Random();
		for (int number = 1; number <= 6; number ++) {
			int randomNumber = randy7.nextInt(49) + 1;
			System.out.printf("%d ", randomNumber);
		}
		
		// math. random second example
		// - in its own class randomPasswordGenerator	
		System.out.println();
		chapter11_ObjectsCreatingAndUsing.RandomPasswordGenerator.main(args);
		
		// Import and use java.util. .. classes
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		while (true) {
			System.out.println("Enter an int: ");
			if (input.hasNextInt()) {
				ints.add(input.nextInt());
			} else {
				break;
			}
		}
		
		System.out.printf("You entered these ints: %s%n", ints.toString());
		
		
	}

}
