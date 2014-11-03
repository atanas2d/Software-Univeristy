package chapter11.examples;

import chapter11.*;

public class Exr03_packages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat badCat = new Cat();
		badCat.name = "Unufre";
		badCat.sayMiau();
		
		System.out.printf("%nNow this is a sequence: %d %d %d %d %d %d %d", Sequence.nextValue(),
				Sequence.nextValue(), Sequence.nextValue(), Sequence.nextValue(),
				Sequence.nextValue(), Sequence.nextValue(), Sequence.nextValue());

	}

}
