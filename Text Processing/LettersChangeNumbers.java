package TextProcessing.Exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input = scanner.nextLine(); //кодове разделени с един или повече интервали
        String[] codes = input.split("\\s+");

        double totalSum = 0; //сума от модифицираните числа на всеки код
        for (String code : codes) {
            //код: {буква}{число}{буква}
            //модифицирам си числото в кода спрямо буквите
            double modifiedNumber = getModifiedNumber(code);
            //добавям модифицираното число към сумата
            totalSum += modifiedNumber;
        }
        System.out.printf("%.2f%n",totalSum);

    }
//метод, който връща модифицираното число от кода
    private static double getModifiedNumber(String code) {
        //код: {буква}{число}{буква} -> А12b
        char firstLetter = code.charAt(0);
        char secondLetter = code.charAt(code.length()-1);
        double number = Double.parseDouble(code.replace(firstLetter, ' ')
                .replace(secondLetter, ' ')
                .trim());
        //1.проверка за първата буква -> главна или малка
        if(Character.isUpperCase(firstLetter)){
            //главна -> ascii е [65 до 90]
            int positionUpperLetter = (int)firstLetter - 64;
            number = number / positionUpperLetter;
        }else{
            //малка -> ascii е [97 до 120]
            int positionLowerLetter = (int)firstLetter - 96;
                    number = number * positionLowerLetter;
        }
        //2.проверка за втората буква -> главна или малка
        if(Character.isUpperCase(secondLetter)){
            //главна -> ascii е [65 до 90]
            int positionUpperLetter = (int)secondLetter - 64;
            number = number - positionUpperLetter;
        }else{
            //малка -> ascii е [97 до 120]
            int positionLowerLetter = (int)secondLetter - 96;
            number = number + positionLowerLetter;
        }
        //връщаm модифицираното число
        return number;
    }

}
