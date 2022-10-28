package FundamentalsMidExamPreparation;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeCapacityPerHour = Integer.parseInt(scanner.nextLine());
        int secondEmployeeCapacityPerHour = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeCapacityPerHour = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int sumOfCapacity = firstEmployeeCapacityPerHour + secondEmployeeCapacityPerHour + thirdEmployeeCapacityPerHour;

        int timeNeeded = 0;
        while (studentsCount > 0){
            studentsCount -= sumOfCapacity;
            timeNeeded++;

            if(timeNeeded % 4 == 0){
                timeNeeded ++;
            }


        }
        System.out.printf("Time needed: %dh.",timeNeeded);
    }
}
