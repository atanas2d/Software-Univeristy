package chapter11_ObjectsCreatingAndUsing;

import java.util.Scanner;

public class Exr02_hypotenuseFinder {

	public static void main(String[] args) {
		// TODO Find the hypotenuse(a) of a right triangle by a given length of cathetus. 
		// a^2 = b^2 + c^2
		
		// get cathetus value
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter the length of cathetus of a triangle (cm): ");
		int c = input.nextInt();
		System.out.printf("%nThe triangle have %dcm lenght of cathetus.", c);
		// make some initial computing before square root 
		int a1 = 2*c*c;		
		double a = Math.sqrt((double)a1);
		System.out.printf("The hypotenuse is %.2fcm.",a);
		

	}

}
