package TextProcessing.Exercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //1. входни данни -> usernames разделени с със ", "
        String input = scanner.nextLine();

        String[] usernames = input.split(", ");

        //2.проверка дали usernames са валидни
        for (String username : usernames) {
            //3. ако username е валиден го отпечатваме
            if(isValidUsername(username)){
                System.out.println(username);
            }

        }
    }
    //метод, който проверява дали моят username е валиден
    //true -> ако username е валиден
    //false -> ако username не е валиден
    public static boolean isValidUsername(String username){
        //1.има ли валидна дължина -> [3,16]
        //boolean isValidLength = username.length() >= 3 && username.length() <= 16;
        if(username.length() < 3 || username.length() > 16){
            return false;
        }
        //валидна дължина

        //2.валидно съдържание -> букви, цифри, -
        //true -> съдържанието не е валидно
        //boolean isValidContent = false;
        for ( char symbol : username.toCharArray()) {
            if(!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_'){
                //невалиден username
                return false;
            }
        }
        //всички символи са обходени и всички символи са валидни
        //isValidContent = true;
        return true;
    }
}

