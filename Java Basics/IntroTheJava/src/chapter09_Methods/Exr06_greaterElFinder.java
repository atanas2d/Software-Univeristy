package chapter09_Methods;

public class Exr06_greaterElFinder {

	/**
	 * @param args
	 */
	public static int getGreaterElIndex(int... numbers) {
		int index = -1;
		for (int i = 1; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i - 1] && numbers[i] > numbers[i + 1]) {
				index = i; 
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Use method that returns the first element from an array that is greater than
		// both adjacent elements to the left and to the right, or return -1 if there isn't such element.
		int[] numbers = {1,10,15,7,8,10,25,1,2,2,2,2,4,4,5,10,8,8,78,7};
		
		System.out.print(getGreaterElIndex(numbers));
	}

}
