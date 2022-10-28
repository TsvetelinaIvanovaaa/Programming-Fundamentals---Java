package FundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phonesList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("End")) {
            String[] commandLine = inputLine.split(" - ");
            String command = commandLine[0];
            if (command.contains("Add")) {
                String item = commandLine[1];
                if (!phonesList.contains(item)) {
                    phonesList.add(item);
                }
            } else if (command.contains("Remove")) {
                String item = commandLine[1];
                if (phonesList.contains(item)) {
                    phonesList.remove(item);
                }
            } else if (command.contains("Bonus phone")) {
                String[] items = commandLine[1].split(":");
                String oldItem = items[0];
                String newItem = items[1];

                if (phonesList.contains(oldItem)) {
                    int indexOldItem = phonesList.indexOf(oldItem);
                    phonesList.add(indexOldItem + 1, newItem);
                }
            } else if (command.contains("Last")) {
                String item = commandLine[1];
                if (phonesList.contains(item)) {
                    int removedItemIndex = phonesList.indexOf(item);
                    phonesList.remove(removedItemIndex);
                    phonesList.add(item);
                }
            }
            inputLine = scanner.nextLine();
        }
        System.out.println(String.join(", ",phonesList));
    }
}
