package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] name = new String[n];
        int[] numbers = new int[n];


        for (int i = 0; i < name.length; i++) {
            name[i] = scanner.nextLine();
        }

        int ascii = 0;
        int asciiCode = 0;
        for (int i = 0; i < name.length; i++) {
            asciiCode = 0;
            String currentName = name[i];
            for (int j = 0; j < currentName.length(); j++) {
                ascii = 0;
                char letter = currentName.charAt(j);
                if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                    ascii = (int) letter;
                    asciiCode += ascii * currentName.length();
                } else if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
                    ascii = (int) letter;
                    asciiCode += ascii * currentName.length();
                } else {
                    ascii = (int) letter;
                    asciiCode += ascii / currentName.length();
                }

            }
            for (int j = i; j < numbers.length; j++) {
                numbers[j] = asciiCode;
            }
        }
        Arrays.sort(numbers);

        for (int element : numbers) {
            System.out.println(element);
        }
    }
}






