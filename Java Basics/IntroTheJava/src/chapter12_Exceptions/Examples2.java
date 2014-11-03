package chapter12_Exceptions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Examples2 {
	
	public static void readFile (String fileName) throws IOException{
		try {
			FileInputStream fis = new FileInputStream(fileName);
			
			try {
				BufferedReader in = new BufferedReader (
					new InputStreamReader (fis));
				try {
					String tmp = null;
					while ((tmp = in.readLine()) != null) {	// tmp gets in.readLine() value. Check if it isn't null
						System.out.println(tmp);
					}
					
					} finally {
						if (in != null) {
							in.close();
						}
				}
				
			} finally {
				if (fis != null) {
					fis.close();
				}
				
			}
		} catch (FileNotFoundException e) {
			System.out.printf("%nError: File %s do not exist.", fileName);
		}
		
	}
	 
	public static void main(String[] args) {
		// TODO Exception chain : first throws, than try {} catch () {} in the main()
		try {
			readFile("C:\\eclipse\\eclipse1.ini");
		}	catch (IOException e) {
			e.printStackTrace();			
		} 		
		finally {
			System.out.printf("%nNow this is the END :-].");
		}
	}

}
