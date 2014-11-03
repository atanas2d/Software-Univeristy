import java.util.Scanner;


public class DecimalToHexadecimal {
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int n = input.nextInt();
		
		System.out.println(Integer.toHexString(n));
		
	}
	

}
