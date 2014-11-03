package chapter11_ObjectsCreatingAndUsing;

import java.util.Random;

public class RandomPasswordGenerator {
	
	private static final String CAPITAL_LETTERS = 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String SMALL_LETTERS = 
			"abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL_CHARS = 
			"~!@#$%^&*()_+=`{}[]\\|':;.,/?<>";
	private static final String ALL_CHARS = 
			CAPITAL_LETTERS + SMALL_LETTERS + DIGITS + SPECIAL_CHARS;
	public static Random rnd = new Random();			

	public static void main(String[] args) {
		// TODO Generate a passowrd, 8 - 15 symbols long with minimum 2 capital letters,
		// minimum 2 small letters and minimum 3 special signs
		
		StringBuilder password = new StringBuilder();
		
		// Generate two random capital letters
		for (int i=1; i<=2; i++) {
			char capitalLetter = generateChar(CAPITAL_LETTERS);
			insertAtRandomPosition(password, capitalLetter);			
		}
		
		// Generate two random small letters
		for (int i=1; i <= 2; i++) {
			char smallLetter = generateChar (SMALL_LETTERS);
			insertAtRandomPosition(password, smallLetter);
		}
		
		// Generate one random digit 
		char digit = generateChar(DIGITS);
		insertAtRandomPosition(password, digit);
		
		// Generate 3 special characters
		for (int i=1; i<=3; i++) {
			char specialChar = generateChar(SPECIAL_CHARS);
			insertAtRandomPosition(password, specialChar);			
		}
		
		// Generate few random characters (between 0 and 7)
		int count = rnd.nextInt(8);
		for (int i=1; i <= count; i++) {
			char anyChar = generateChar (ALL_CHARS);
			insertAtRandomPosition(password, anyChar);
		}
		
		System.out.println(password);		
	}
	
	private static void insertAtRandomPosition (StringBuilder password, char character) {
		int randomPosition = rnd.nextInt(password.length()+1);
		password.insert(randomPosition,  character);
	}
	
	private static char generateChar (String availableChars) {
		int randomIndex = rnd.nextInt(availableChars.length());
		char randomChar = availableChars.charAt(randomIndex);
		return randomChar;
	}

}
