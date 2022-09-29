package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int digit = number % 10;
        //int lastDigit = digit / 10;

        if(digit == 0){
            System.out.println("zero");
        }else if(digit == 1){
            System.out.println("one");
        }else if(digit == 2){
            System.out.println("two");
        }else if(digit == 3){
            System.out.println("three");
        }else if(digit == 4){
            System.out.println("four");
        }else if(digit == 5){
            System.out.println("five");
        }else if(digit == 6){
            System.out.println("six");
        }else if(digit == 7){
            System.out.println("seven");
        }else if(digit == 8){
            System.out.println("\teight");
        }else if(digit == 9){
            System.out.println("nine");
        }
    }
}
