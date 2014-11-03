import java.util.Scanner;


public class _01_SymetricNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int start = input.nextInt();
		int end = input.nextInt();
		
		for (int i = start; i <= end; i++) {
			String num = Integer.toString(i);
			int l = num.length();
			boolean symetric = true;
			for (int j = 0; j < l/2; j++) {
				if (num.charAt(j) != num.charAt(l - j - 1)) {
					symetric = false;
				}				
			}
			if (symetric) {
				System.out.printf("%s; ", num);			
			}
		}
	}

}
