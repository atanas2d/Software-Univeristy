import java.util.Scanner;


public class CountTheBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		int n = input.nextInt();
		
		String bin = Integer.toBinaryString(n);
		int counter = 0;
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				counter++;
			}
		}
		
	
	}

}
