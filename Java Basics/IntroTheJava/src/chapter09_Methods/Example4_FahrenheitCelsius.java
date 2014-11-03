package chapter09_Methods;

import java.util.Scanner;

public class Example4_FahrenheitCelsius {

	/**
	 * @param args
	 */
	public static double getCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32)*5/9;
		return celsius;
	}
	
	public static void main(String[] args) {
		// TODO Fahrenheit - Celsius conversion	(body temperature)
		System.out.print("Enter Fahrenheit temperature: ");
		Scanner input = new Scanner(System.in);
		double fahrenheit = input.nextDouble();
		System.out.println();
		
		double temperature = getCelsius(fahrenheit);
		System.out.printf("Your temperature in Celsius degrees is %f. %n", temperature);
		
		if (temperature > 37.0) {
			System.out.print("You are ill.");
		}
		input.close();		
	}

}
