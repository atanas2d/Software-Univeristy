package chapter11_ObjectsCreatingAndUsing;

import java.util.Random;

public class Exr05_Advertising {
	
	private static final String[] LAUDATORY_PHRASES = {
		"Продуктът е отличен.",
		"Това е страхотен продукт.",
		"Постоянно ползвам този продукт.",
		"Това е най-добрия продукт в тази категория."
	};
	
	private static final String[] LAUDATORY_FACTS = {
		"Вече се чувствам добре.",
		"Успях да се променя.",
		"Той направи чудо.",
		"Не мога да повярвам, но вече се чувствам страхотно",
		"Опитайте и вие. Аз съм много доволна."
	};
	
	private static final String[] AUTHOR_FIRST_NAME = {
		"Диана","Петя","Стела","Елена","Катя"
	};
	
	private static final String[] AUTHOR_LAST_NAME = {
		"Иванова","Петрова","Кирова","Димитрова","Георгиева"
	};
	
	private static final String[] CITIES = {
		"София","Варна","Пловдив","Русе","Бургас"
	};
	
	private static Random rnd = new Random();

	public static void main(String[] args) {
		// TODO Generate random advertising message by author from a city/town.
		
		System.out.printf("%s %s -- %s %s, %s",LAUDATORY_PHRASES[rnd.nextInt(LAUDATORY_PHRASES.length)],
				LAUDATORY_FACTS[rnd.nextInt(LAUDATORY_FACTS.length)], AUTHOR_FIRST_NAME[rnd.nextInt(AUTHOR_LAST_NAME.length)],
				AUTHOR_LAST_NAME[rnd.nextInt(AUTHOR_LAST_NAME.length)], CITIES[rnd.nextInt(CITIES.length)]
				);	
	}

}
