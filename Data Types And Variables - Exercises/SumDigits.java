package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int number =Integer.parseInt(scanner.nextLine());
        //1.взимаме последната цифра с %
        //2.сумираме
        //махаме последната цифра /
        //спираме,когато числото ни е <=0
        int sum = 0;
        while (number>0){
            int lastDigit = number % 10;
            sum +=lastDigit;
            number = number / 10;

        }
        System.out.println(sum);
    }
}
