package DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        double lastDigit = 0;


        for (int i = 1; i <= n ; i++) {

            //int number = scanner.nextInt();
            double firstNumber = scanner.nextDouble();
            double secondNumber = scanner.nextDouble();

            sum = 0;
            if (firstNumber > secondNumber){
                double num1 = Math.abs(firstNumber);
                while (firstNumber>0) {
                    lastDigit = firstNumber % 10;
                    sum += lastDigit;
                    firstNumber = firstNumber / 10;
                }
                System.out.println(sum);
            }else{
                while (secondNumber>0) {
                    lastDigit = secondNumber % 10;
                    sum += lastDigit;
                    secondNumber = secondNumber / 10;
                }
                System.out.println(sum);
            }
           // for (int j = 0; j < input.length(); j++) {
           //     char symbol = input.charAt(j);
           //     if('0'<= symbol && symbol <= '9'){
           //         if( symbol == '\t');

           //         int digit = symbol - '0';
           //        number *= 10;
           //         number += digit;

                }

            }

        }


