package FundamentalsMidExamPreparation;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        int lastIndexStop = 0;

        while (!command.equals("Love!")) {
            String[] commandElements = command.split(" ");

            int jumpLength = Integer.parseInt(commandElements[1]);

            for (int i = lastIndexStop; i < numbersList.size(); i++) {
                int currentIndex = lastIndexStop + jumpLength;

                if (currentIndex >= numbersList.size()) {
                    currentIndex = 0;
                }

                if (numbersList.get(currentIndex) == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
                } else {

                    numbersList.set(currentIndex, numbersList.get(currentIndex) - 2);

                    if (numbersList.get(currentIndex) <= 0) {
                        System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                    }

                }
                lastIndexStop = currentIndex;
                break;
            }
            command = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", lastIndexStop);

        boolean allHadValentinesDay = true;
        int leftHouses = 0;

        for (int element : numbersList) {
            if (element > 0) {
                allHadValentinesDay = false;
                leftHouses++;
            }
        }

        if (allHadValentinesDay) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", leftHouses);
        }
    }
}

