package DataTypesAndVariables.Exercises;

import java.math.BigDecimal;
import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double snowballValue = 0;
        double maxValue= Double.MIN_VALUE;
        double snow = 0;
        double time = 0;
        double quality = 0;

        for (int i = 1; i <= n ; i++) {
            snowballValue = 0;
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            snowballValue += Math.pow((snowballSnow*1.0/snowballTime),snowballQuality*1.0);

            if (snowballValue > maxValue){
                maxValue = snowballValue;
                snow = snowballSnow;
                time = snowballTime;
                quality = snowballQuality;
            }

        }

        System.out.printf("%.0f : %.0f = %.0f (%.0f)",snow,time,maxValue,quality);
    }
}
