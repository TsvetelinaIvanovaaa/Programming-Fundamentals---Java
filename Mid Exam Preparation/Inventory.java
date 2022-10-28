package FundamentalsMidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventoryList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Craft!")) {
            String[] commandLine = inputLine.split(" - ");
            String command = commandLine[0];
            if (command.contains("Collect")) {
                String item = commandLine[1];
                if (!inventoryList.contains(item)) {
                    inventoryList.add(item);
                }
            } else if (command.contains("Drop")) {
                String item = commandLine[1];
                if (inventoryList.contains(item)) {
                    inventoryList.remove(item);
                }
            } else if (command.contains("Combine Items")) {
                String[] items = commandLine[1].split(":");
                String oldItem = items[0];
                String newItem = items[1];

                if(inventoryList.contains(oldItem)){
                    int indexOldItem = inventoryList.indexOf(oldItem);
                    inventoryList.add(indexOldItem + 1, newItem);
                }
            } else if (command.contains("Renew")){
                String renewItem = commandLine[1];
                if(inventoryList.contains(renewItem)){
                    inventoryList.remove(renewItem);
                    inventoryList.add(renewItem);
                }
            }


            inputLine = scanner.nextLine();
        }
        System.out.println(String.join(", ",inventoryList));
    }
}
