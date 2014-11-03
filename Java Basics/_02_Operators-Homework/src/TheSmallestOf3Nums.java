import java.util.Scanner;


public class TheSmallestOf3Nums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		float smallest = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			float n = input.nextFloat();
			if (n < smallest) {
				smallest = n;
			}
		}
		System.out.println(smallest);
	}

}
