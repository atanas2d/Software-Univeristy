import java.util.Scanner;


public class PointsInsideFigure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		float x = input.nextFloat();
		float y = input.nextFloat();
		
		if ((y >= 6 && y <= 13.5) && (x >= 12.5 && x <= 22.5)) {
			if ((y <= 8.5)) {
				System.out.println("Inside");
			} else if (x <= 17.5 || x >= 20) {
				System.out.println("Inside");
			}
		} else {
			System.out.println("Outside");
		}

	}

}
