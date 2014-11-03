import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by atanasWin on 10/5/2014.
 */
public class SortArrayOfStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = input.nextLine();
        }
        Arrays.sort(words);
        System.out.print(Arrays.toString(words));
    }
}
