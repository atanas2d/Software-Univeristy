package chapter09_Methods;

public class Exr01_helloName {

	/**
	 * @param args
	 */
	public static void printHelloName(String name) {
		System.out.printf("Hello, %s!", name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Mariya";		
		printHelloName(name);
	}

}
