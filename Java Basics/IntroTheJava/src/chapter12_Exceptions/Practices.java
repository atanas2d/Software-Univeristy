package chapter12_Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.rules.ExpectedException;

public class Practices {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Standard code for reading file
		File f = new File ("C:\\Eclipse\\eclipse1.ini");
		if (!f.exists()) {
			System.out.println("The file does not exist...");
			return;
		}
		
		Scanner scan = new Scanner(f);
		String line = scan.nextLine();
		System.out.println("The first line of the file: " + line);
		

	}

}
