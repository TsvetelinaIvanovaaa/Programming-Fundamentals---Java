package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String reversesWord = "";
        String newWord = "";

        for (int i = word.length()-1; i >=0 ; i--) {
            reversesWord += word.charAt(i);

        }
       newWord = reversesWord;
        System.out.println(newWord);
    }
}
