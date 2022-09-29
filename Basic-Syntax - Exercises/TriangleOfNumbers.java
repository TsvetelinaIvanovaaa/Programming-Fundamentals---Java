package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int currentNumber = 0;

        for (int row = 1; row <= n; row++) {
            currentNumber++;
            for (int col = 1; col <= row; col++) {

                if (currentNumber > n) {
                    break;
                }
                System.out.print(row + " ");
            }
            if(currentNumber > n){
                break;
            }
            System.out.println();
        }
    }
}
