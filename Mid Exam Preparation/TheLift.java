package FundamentalsMidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());
        int[] wagonArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumPeopleInTrain = 0;

        for (int i = 0; i < wagonArr.length; i++) {

            int currentWagon = wagonArr[i];
            int capacityWagon = 4 - wagonArr[i];
            int countPeopleToGet = Integer.min(countPeople, capacityWagon);
            wagonArr[i] = currentWagon + countPeopleToGet;
            countPeople -= countPeopleToGet;
            sumPeopleInTrain += wagonArr[i];
        }

        if (countPeople > 0 && wagonArr.length * 4 == sumPeopleInTrain) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", countPeople);
            print(wagonArr);

        } else if (countPeople == 0 && wagonArr.length * 4 == sumPeopleInTrain){
            print(wagonArr);
        } else if (countPeople == 0 && wagonArr.length * 4 > sumPeopleInTrain ){
            System.out.println("The lift has empty spots!");
            print(wagonArr);
        }

    }

    private static void print(int[] wagonArr) {
        for (int i = 0; i < wagonArr.length; i++) {
            System.out.print(wagonArr[i] + " ");
        }
    }
}