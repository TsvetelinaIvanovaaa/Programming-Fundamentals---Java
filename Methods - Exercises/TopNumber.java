package Methods.Exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n ; number++) {
            //проверка дали е топ число
            //сумата от цифрите да се дели на 8
            //да съдържа поне една нечетна цифра
            if( isSumOfDigitDivisibleBy8(number) && isContainedOddDigit(number)){
                System.out.println(number);
            }
        }
    }
    //метод, който проверява дали сумата от цифрите се дели на 8
    //true -> ако сумата се дели на 8
    //false -> ако сумата не се дели на 8
    public static boolean isSumOfDigitDivisibleBy8(int number){
        //1.сума от цифрите
        int sumDigit = 0;
        while(number > 0){
            //взимам последната цифра
            int lastDigit = number % 10;
            //сумирам последната цифра
            sumDigit += lastDigit;
            //премахвам последната цифра от числото
            number = number / 10;
        }
        //2.проверка на сумата за деление с 8
        //return sumDigit % 8 == 0;
        //щом в израза имам оператор за сравнени, то това е булев израз и ни връша true или false
        if(sumDigit % 8 == 0){
            return true;
        }else{
            return false;
        }
    }
    //метод, който ми проверява дали имам поне една нечетна цифра в числото
    //true -> имам поне една нечетна цифра
    //false -> нямам поне една нечетна цифра
    public static boolean isContainedOddDigit (int number){
        //да обходя всяка цифра във числото -> правя проверка дали е нечетна
        while (number > 0){
            //взимам последната цифра
            int lastDigit = number % 10;
            //проверявам дали е нечетна
            if(lastDigit % 2 != 0){
                return true;
            }else{
                //цифрата да е четна -> premahwam q
                number = number / 10;
            }
        }
        //взели сме всички цифри и никоя не е била нечетна
        return false;
    }
}
