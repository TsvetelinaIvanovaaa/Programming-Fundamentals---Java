package Methods.Exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String passwordInput = scanner.nextLine();

        boolean isPasswordLengthValid = isCountDigitBetween6and10(passwordInput);

        if (!isPasswordLengthValid) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean isPasswordContentValid = isContainedOnlyLettersAndDigit(passwordInput);
        if (!isPasswordContentValid) {
            System.out.println("Password must consist only of letters and digits");
        }


        boolean isPasswordCountDigitValid = isContainedAtLeast2Digit(passwordInput);
        if (!isPasswordCountDigitValid) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isPasswordLengthValid && isPasswordContentValid && isPasswordCountDigitValid) {
            System.out.println("Password is valid");
        }
    }

    //метод, който прави проверка дали паролата е между 6 и 10 символа
    public static boolean isCountDigitBetween6and10(String text) {
        int countDigit = text.length();
        if (countDigit >= 6 && countDigit <= 10) {
            return true;
        } else {
            return false;
        }
    }
    //метод, който прави проверка дали се състои само от букви и цифри
    public static boolean isContainedOnlyLettersAndDigit(String text) {
        for (char symbol : text.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
    //метод,който проверява дали в паролата има поне две цифри
    public static boolean isContainedAtLeast2Digit(String text) {
        int countOfDigit = 0;
        for(char symbol : text.toCharArray()){
            if(Character.isDigit(symbol)){
                countOfDigit++;
            }
        }
        if (countOfDigit >= 2) {
            return true;
        } else {
            return false;
        }
    }
}



