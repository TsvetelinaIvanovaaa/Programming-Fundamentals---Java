package DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class RefactoringPrimeChecker {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= number; i++) {
            boolean isLie = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isLie = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isLie);
        }

    }
}
