package chapter11_ObjectsCreatingAndUsing;

import chapter11.Cat;
import chapter11.Sequence;

public class Examples1 {

	public static void main(String[] args) {
		// TODO Examples in Objects Creating chapter
		
		// Creating a cat object (from class Cat):
		Cat someCat = new Cat();
		// Creating a cat object with parameters by using a constructor of Cat():
		Cat myBrownCat = new Cat("Johnny","brown");
		
		// Manual release an object:
		// myBrownCat = null;
		
		Cat justCat = new Cat();		
		// Access to object fields:
		justCat.name = "Alfred";
		// Test object field changes:
		System.out.printf("The name of justCat is: %s.\n", justCat.name);		
		
		// Access to object methods:
		myBrownCat.setName("Garfild");
		// Test object methods changes:
		System.out.printf("The name of myBrownCat is: %s.%n",myBrownCat.getName());
		myBrownCat.sayMiau();
		
		// Static fields and methods examples
		System.out.println();
		System.out.printf("Sequence[1..3]: %d,%d,%d%n", Sequence.nextValue(), Sequence.nextValue(),
				Sequence.nextValue());
		

	}

}
