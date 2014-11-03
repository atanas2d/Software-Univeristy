import java.util.Scanner;


public class _02_Generate3LetterWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		char[] letters = input.next().toCharArray();
		
		int l = letters.length;
		
		for (int a = 0; a < l; a++) {
			for (int b = 0; b < l; b++) {
				for (int c = 0; c < l; c++) {
					System.out.printf("%s%s%s ",letters[a], letters[b], letters[c]);
				}
			}
		}
	}

}
