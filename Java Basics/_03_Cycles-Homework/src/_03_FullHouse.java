import java.lang.reflect.Array;
import java.util.Arrays;


public class _03_FullHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] face = new String[13];
		for (int i = 0; i < face.length; i++) {
			switch (i) {
			case 9: face[i] = "J"; break;
			case 10: face[i] = "Q"; break;
			case 11: face[i] = "K"; break;
			case 12: face[i] = "A"; break;
			default: face[i] = Integer.toString(i + 2);
			}			
		}
		
		char[] suit = new char[4];
		for (int i = 0; i < 4; i++) {
			switch(i) {
			case 0: suit[i] = '♣'; break;
			case 1: suit[i] = '♦'; break;
			case 2: suit[i] = '♥'; break;
			case 3: suit[i] = '♠'; break;
			
			}
		}
		
		String[] cards = new String[52];
		int counter = 0;
		for (int s = 0; s < suit.length; s++) {
			for (int f = 0; f < face.length; f++) {
				cards[counter++] = face[f] + suit[s];
				System.out.printf("%s ", cards[counter - 1]);
			}
		}
		String[] combo = new String[5];
		int[] i = new int[5];
		int fullHouseCombos = 0;
		for (i[0] = 0; i[0] < cards.length; i[0] ++ ) {
			for (i[1] = i[0] + 1; i[1] < cards.length; i[1] ++ ) {
				for (i[2] = i[1] + 1; i[2] < cards.length; i[2] ++ ) {
					for (i[3] = i[2] + 1; i[3] < cards.length; i[3] ++ ) {
						for (i[4] = i[3] + 1; i[4] < cards.length; i[4] ++ ) {
							for (int ii = 0; ii < i.length; ii++ ) {
								combo[ii] = cards[i[ii]];								
							}
							if (isFullHouse(combo)) {
								fullHouseCombos++;
							}
						}
					}
				}
			}
			
		}		
		System.out.println();
		System.out.println(fullHouseCombos);	
		
	}
	
	public static boolean isFullHouse(String[] combo) {
		boolean isFullHause = true; 
		// remove the suit
		for (int i = 0; i < combo.length; i++) {
			combo[i] = combo[i].substring(0, combo[i].length() - 1);
		} 
		int counter = 0;
		for (int i = 1; i < combo.length; i++) {
			if (combo[0].equals(combo[i])) {
				counter++;
				combo[i] = "*";
			}
		}
		switch (counter) {
		case 1: 
			combo[0] = "*";
			String[] elements = new String[3];
			int index = 0;
			for (int i = 0; i < combo.length; i++) {
				if (!combo[i].equals("*")) {
					elements[index++] = combo[i];
				}
			}
			for (int i = 1; i < elements.length; i++ ) {
				if (!elements[0].equals(elements[i])) {
					isFullHause = false;
				}
			}
			break;
		case 2: 
			combo[0] = "*";
			elements = new String[2];
			index = 0;
			for (int i = 0; i < combo.length; i++) {
				if (!combo[i].equals("*")) {
					elements[index++] = combo[i];
				}
			}
			if (!elements[0].equals(elements[1])) {
				isFullHause = false;
			}
			break;
			default: isFullHause = false;
		}		
		return isFullHause;
	}

}
