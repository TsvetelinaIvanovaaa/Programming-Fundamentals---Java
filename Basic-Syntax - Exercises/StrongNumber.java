package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input = scanner.nextLine();
        int number = Integer.parseInt(input);
        int num = number;
        int allDigitsFact = 0;

        for (int i = 0; i < input.length(); i++) {

            //char c = input.charAt(i);
            //int digit2 = c;
            //System.out.println(digit2);
            //това ни връща аски стойността на тази променлива (на всяка цифра от числото);

            //String symbol = String.valueOf(input.charAt(i));
            //взимаме стринговата стойност на дадения символ и го парсваме по стандартния начин...
            //int digit2 = Integer.parseInt(symbol);
            //System.out.println(digit2); - имамв всичките цифри ит дадено число...

            //String symbol = "" + input.charAt(i);
            //решение с конкатенация; взимаме всяка отделна цифра от числото;

            int digit = num % 10;
            num /= 10;
            int fact = 1;
            for (int j = 1; j <= digit ; j++) {
                fact *= j;
            }
            allDigitsFact += fact;
        }
        if(number == allDigitsFact){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}

    //int number = Integer.parseInt(scanner.nextLine()); // това е числото,което на долу ще модифицираме
    //int startNumber = number; //ще държа първоначално въведената стойност на числото
    //int sumFact = 0;
        //while (number > 0){
                //int lastDigit = number % 10; //взимам последната цифра
                //намирам факториела
                //int fact = 1;
                //for (int i = 1; i <= lastDigit ; i++) {
                //fact = fact * i;
               // }
                //сумирам факториела
                //sumFact += fact;
                //number = number / 10;//премахваме последната цифра

                //}
                //if(sumFact == startNumber){
                //System.out.println("yes");
                //}else{
                //System.out.println("no");
                //}