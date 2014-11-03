package chapter12_Exceptions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Examples1 {
	
	public static void readFile(String fileName) {
		try {
			// Exception could be thrown below
			FileInputStream fis = new FileInputStream (fileName);
			BufferedReader in = new BufferedReader (
					new InputStreamReader(fis));
			String tmp = null;
			while ((tmp = in.readLine()) != null) {
				System.out.println(tmp);
			}
			in.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// Exception handler for FileNotFoundException
			System.out.println("The file \"" + fileName + "\" does not exist! Unable to read it.");
		} catch (IOException e) {
			// Exception handler for IOException
			e.printStackTrace();
		}
		
	}
	
	public static void readFileSE(String fileName) 
			throws FileNotFoundException, IOException {
		FileInputStream fis = null;
		fis = new FileInputStream(fileName);
		BufferedReader in = new BufferedReader (
				new InputStreamReader (fis));
		String tmp = null;
		while ((tmp = in.readLine()) != null) {
			System.out.println(tmp);
		}
	}
	
	public static void exceptionChain1() {
		try { 
			throw new NullPointerException("Problem");
		} catch (NullPointerException npe) {
			throw new RuntimeException(npe);
		}
		
	}
	
	public static void main(String[] args) {
		String fileName = "C:\\eclipse\\eclipse11.ini";
		// TODO Examples for work with exceptions		
		// Try to work with readFile() exceptions
		
//		try {
//			readFileSE(fileName);
//		}
//		catch (Exception e) {
//			System.out.println("Error");
//			e.printStackTrace();
//		}
	
		//readFile(filName);
		//exceptionChain1();
		
	}

}
