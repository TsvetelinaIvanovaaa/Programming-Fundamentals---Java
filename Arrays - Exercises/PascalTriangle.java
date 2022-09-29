package Arrays.MoreExercise;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] cols = new int[n];
        int[] rows = new int[n];

        //int currentNumber=0;

        for (int i = 0; i < n ; i++) {
            int number = 1;

            for (int j = 0; j <= i ; j++) {
                System.out.print(number + " ");
                number = number * (i-j)/(j+1);
            }
            System.out.println();
        }

    }
}
