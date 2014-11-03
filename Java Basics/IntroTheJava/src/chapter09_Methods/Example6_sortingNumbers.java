package chapter09_Methods;

public class Example6_sortingNumbers {

	/**
	 * @param args
	 */
	public static int[] sort(int... numbers) {
		
		for (int i = 0; i < numbers.length - 1; i++) {
			
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int tempVar = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = tempVar;
				}
			}
		}
		
		return numbers;
	}
	
	public static void printNumbers (int... numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]);
			if (i < numbers.length - 1) {
				System.out.print(", ");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Sort a sequence of entered numbers and return an array with them.
		int[] numbers = sort(3,0,-100,5,10,11,7,8,2,11101,-1111,-7,7,-8);
		printNumbers(numbers);
	}

}
