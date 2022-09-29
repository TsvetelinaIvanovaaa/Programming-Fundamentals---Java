package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int count = 0;
        int startPower = power;
        while (power >= distance){
            power -= distance;
            count ++;
            if(power == startPower * 0.5){
                if(exhaustionFactor > 0){
                    power /= exhaustionFactor;
                }
            }
        }
        System.out.println(power);
        System.out.println(count);
    }
}
