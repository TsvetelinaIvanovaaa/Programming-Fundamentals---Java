package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class WaterOverflow1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //колко пъти ще се налива вода
        int totalLiters = 0;
        int capacity = 255;

        for (int i = 0; i < n; i++){
            int liters = Integer.parseInt(scanner.nextLine());
            //totalLiters += liters;

            if (totalLiters + liters > capacity){
                System.out.println("Insufficient capacity!");

            }else{
                totalLiters += liters;
            }

        }
        System.out.println(totalLiters);
    }
}
