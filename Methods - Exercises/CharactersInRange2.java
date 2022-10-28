package Methods.Exercise;

import java.util.Scanner;

import static Methods.Exercise.CharactersInRange.printCharactersInRange;

public class CharactersInRange2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);

        printCharactersInRange(symbol1,symbol2);
    }
    public static void printCharactersInRange(char symbol1, char symbol2){
        if(symbol1 < symbol2){
            for (char symbol = (char)(symbol1+1); symbol < symbol2; symbol++) {
                System.out.print(symbol + " ");
            }
        }else{
            for (char symbol = (char)(symbol2+1); symbol < symbol1; symbol++) {
                System.out.print(symbol + " ");
            }
        }
    }
}
