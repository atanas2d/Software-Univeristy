package chapter09_Methods;

public class Examples1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Examples for methods (~ subroutines, functions, procedures)		
		double width = 5;
		double height = 10;
		double area = getRectangleArea (width, height);
		System.out.println(area);
		
		double[] prices = new double[] {1,2,3,4,5};
		printTotalAmountForBooks(prices);
		
		

	}
	// Method for calculating an area of a rectangle:
	public static double getRectangleArea ( double width, double height) {
		double area = width * height;
		return area;			
	}
	// Method for printing logo of a company
	public static void printLogo() {
		System.out.println("Nasko Microsystems");
		System.out.println("www.atanas2d.blog.bg");
	}
	// Method for calculating the price of all books in the basket
	public static void printTotalAmountForBooks(double... prices) {
		double totalAmount = 0;
		
		for (double singleBookPrice : prices) {
			totalAmount += singleBookPrice; 
		}
		System.out.println("The total amount of all books is: " + totalAmount);
		
	}
	


}
