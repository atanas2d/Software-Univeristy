import java.util.Scanner;


public class TriangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int ax = input.nextInt();
		int ay = input.nextInt();
		
		int bx = input.nextInt();
		int by = input.nextInt();
		
		int cx = input.nextInt();
		int cy = input.nextInt();
		
		if ((ax*(by - cy) + bx*(cy - ay) + cx*(ay - by)) == 0) {
			System.out.println("0");
			return;
		}
		
		float area = (ax*(by - cy) + bx*(cy - ay) + cx*(ay - by))/2;
		area = Math.abs(area);
		area = Math.round(area);
		System.out.println(area);
		
		
	}

}
