package chapter10_Recursion;

public class Examples1 {

	/**
	 * @param args
	 */
	
	
	public static long factorialRec(int n) {
		// The bottom of the recursion:
		if (n == 0) {
			return 1;
		}
		// Recursive call: the method calls itslef
		else {
			return n * factorialRec(n - 1);
		}
	}
	
	
	public static long factorialIter(int n) {
		long result = 1; 
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Examples for recursion
		
		// N! by recursion / iteration:
		int n = 18;
		long fac = factorialIter(n);
		System.out.printf("%d! is: %d. ",n, fac);
		
	
		

	}

}
