package Methods.Exercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);

        printCharactersInRange(firstSymbol, secondSymbol);
    }

    public static void printCharactersInRange(char symbol1, char symbol2) {
        int nextSymbol1 = (int)symbol1 + 1;
        char nextCharSymbol1 = (char)nextSymbol1;
        if((int)symbol2 < (int) nextCharSymbol1){
            int nextSymbol2 = (int)symbol2 + 1;
            char nextCharSymbol2 = (char)nextSymbol2;
            for (char letter = nextCharSymbol2; letter < symbol1; letter++) {
                System.out.print(letter + " ");
            }
        }else{
            for (char letter = nextCharSymbol1 ; letter < symbol2; letter++) {
                System.out.print(letter + " ");
        }

        }
    }
}
