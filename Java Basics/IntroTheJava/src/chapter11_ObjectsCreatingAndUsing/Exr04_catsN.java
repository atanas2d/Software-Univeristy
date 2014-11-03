package chapter11_ObjectsCreatingAndUsing;

import chapter11.*;

public class Exr04_catsN {

	public static void main(String[] args) {
		// TODO use "chapter11" package to create 10 Cat() objects namet CatN (N = number), and make
		// them say miauu
		
		// Creating mutable string for a cat name
		StringBuilder catN = new StringBuilder();
		catN.append("Cat");
		
		// Create 10 cats array		
		Cat[] tenCats = new Cat[10];		
		
		// Make first value 1 instead of 0; 
		Sequence.nextValue();
		
		// generate 10 different cat names "Cat#"
		for (int i = 0; i < 10; i++ ) {
			catN.append(Sequence.nextValue());
			// initialize cat Object first
			tenCats[i] = new Cat();
			tenCats[i].name = catN.toString();
			catN.deleteCharAt(3);
		}
		
		// make them say Miauu
		for (int i = 0; i < 10; i++) {
			tenCats[i].sayMiau();
		}

	}

}
