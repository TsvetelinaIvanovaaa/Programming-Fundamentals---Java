package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int ascii = 0;
        double asciiSum = 0;
        String strongWord = " ";
        char firstLetter = 0;
        double maxSum = 0;

        while (!word.equals("End of words")) {
            firstLetter = 0;
            asciiSum = 0;
            int wordLength = word.length();
            for (int i = 0; i < word.length(); i++) {
                firstLetter = word.charAt(0);
                ascii = word.charAt(i);
                asciiSum += ascii;
            }
            if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o'
                    || firstLetter == 'u' || firstLetter == 'y'
                    || firstLetter == 'A' || firstLetter == 'E' || firstLetter == 'I'
                    || firstLetter == 'O' || firstLetter == 'U' || firstLetter == 'Y') {
                 asciiSum *= wordLength;
            }else{
                asciiSum = Math.floor(ascii * 1.0 / wordLength);
            }
            if(asciiSum > maxSum){
                maxSum = asciiSum;
                strongWord = word;
            }

            word = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %.0f", strongWord, maxSum);
    }
}
