package FundamentalsMidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String> groceriesList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while(!inputLine.equals("Go Shopping!")){
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[0];
            if(command.contains("Urgent")){
                String item = commandLine[1];
                if (!groceriesList.contains(item)) {
                    groceriesList.add(0, item);
                }
            }else if(command.contains("Unnecessary")){
                String item = commandLine[1];
                if(groceriesList.contains(item)){
                    groceriesList.remove(item);
                }
            }else if(command.contains("Correct")){
                String oldItem = commandLine[1];
                String newItem = commandLine[2];
                if(groceriesList.contains(oldItem)){
                    int indexOldItem = groceriesList.indexOf(oldItem);
                    groceriesList.set(indexOldItem, newItem);
                }
            }else if(command.contains("Rearrange")){
                String item = commandLine[1];
                if(groceriesList.contains(item)){
                    int indexItem = groceriesList.indexOf(item);
                    groceriesList.remove(indexItem);
                    groceriesList.add(item);
                }
            }
            inputLine = scanner.nextLine();
        }
        System.out.println(String.join(", ",groceriesList));
    }
}
