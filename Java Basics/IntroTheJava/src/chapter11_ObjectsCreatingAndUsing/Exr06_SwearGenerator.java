package chapter11_ObjectsCreatingAndUsing;

import java.util.Random;

public class Exr06_SwearGenerator {
	
	private static final String[] ACTION = {
		"Ще те еба в ", "Да ти го набия в ",
		"На майка ти в ", "Да ти го нажмуля у ",
		"Да ти го сложа в ", "Ще те плющя като брашлян чувал в ",
		"Да ти се изплюя в ", "Ще ти сложа пиратка в "
	};
	
	private static final String[] NOUNS = {
		"устата ", "гъза ", "путката ", "шундака "
	};
	
	private static final String[] ADDRESSES = {
		"тъпанар", "тепигьоз", "капут", "лайномет", "мюмюн такъв", "дъждовен червей", "карабатак"
	};
	
	private static final String[] EPITHET = {
		"шибан ", "гнусен ", "трътлесет ", "дрисък ", "петнист ", "мухлясъл "
	};
			
	private static Random rnd = new Random();

	public static void main(String[] args) {
		// TODO Generate swear sentences
		// Define salutation:
		String salutation = "";
		
		switch (rnd.nextInt(3)) {
		case 0: salutation = ADDRESSES[rnd.nextInt(ADDRESSES.length)]; break;
		case 1: salutation = EPITHET[rnd.nextInt(EPITHET.length)]
				+ ADDRESSES[rnd.nextInt(ADDRESSES.length)]; break;
		case 2: salutation = EPITHET[rnd.nextInt(EPITHET.length)] + 
				EPITHET[rnd.nextInt(EPITHET.length)]
						+ ADDRESSES[rnd.nextInt(ADDRESSES.length)]; break;
			
		}
		// Print the result:
		System.out.printf("%s%s%s!", ACTION[rnd.nextInt(ACTION.length)], NOUNS[rnd.nextInt(NOUNS.length)],
				salutation);

	}

}
