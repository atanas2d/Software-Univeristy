package chapter09_Methods;

import java.util.Scanner;

public class Example5_dataValidation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Enter time (HH:MM) and validate the entry.
		System.out.print("What time is it? (HH:mm): ");
		Scanner input = new Scanner(System.in).useDelimiter("[:;.\\s]+");
		int hours = input.nextInt();
		int minutes = input.nextInt();
		input.close();
		System.out.println();
		
		boolean valid = isTimeValid(hours, minutes);
		if (valid) {
			System.out.printf("The time now is %02d:%02d.", hours, minutes);
		} else {
			System.out.print("Incorrect time");
		}
	}
	
	public static boolean isTimeValid(int hours, int minutes) {
		boolean valid = (hours >= 0) && (hours <= 24) && (minutes >= 0) && (minutes <= 60);		
		return valid;
	}

}
