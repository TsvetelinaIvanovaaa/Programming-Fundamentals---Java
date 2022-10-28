package Methods.Exercise;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой на редовете, който е равен на броя на колоните

        printMatrix(n);
    }

    public static void printMatrix(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
