import java.text.DecimalFormat;
import java.util.Scanner;


public class FormattingNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		float b = input.nextFloat();
		float c = input.nextFloat();
		
		String result = "";
		for (int i = 1; i <= 4; i++) {
			result += "|";
			int l = 0;
			switch (i) {
			case 1: 
				String hex = Integer.toHexString(n);
				result += hex;
				l = hex.length();
				for (int ii = 0; ii < 10 - l ;ii++ ) {
					result += " ";
				}
				break;
			case 2: 
				String bin = Integer.toBinaryString(n);
				l = bin.length();
				for (int ii = 0; ii < 10 - l; ii++ ) {
					result += "0";					
				}
				result += bin;
				break;
			case 3:				
				DecimalFormat floatTwo = new DecimalFormat("#.00");
				String bFormatted = floatTwo.format(b);
				l = bFormatted.length();
				for (int ii = 0; ii < 10 - l; ii++ ) {
					result += " ";					
				}
				result += bFormatted;
				break;
			case 4: 
				DecimalFormat floatThree = new DecimalFormat("#.000");
				String cFormatted = floatThree.format(c);
				l = cFormatted.length();
				result += cFormatted;
				for (int ii = 0; ii < 10 - l; ii++ ) {
					result += " ";					
				}			
				break;
			}				
		}
		result += "|";		
		System.out.println(result);
		
	}

}
