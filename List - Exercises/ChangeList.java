package List.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        //stop: command == "end"
        //continue: command != "end"

        while (!command.equals("end")) {
            //команда
            //1.command = "Delete 3"

            if (command.contains("Delete")) {
                //"Delete 3".split(" ") -> ["Delete", "3"]
                int numberForRemove = Integer.parseInt(command.split(" ")[1]);
                //премахваме всички стойности от списъка равни на numberForRemove
                numbersList.removeAll(Arrays.asList(numberForRemove));
            }
            //2.command = "Insert 1 3 "
            else if (command.contains("Insert")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                int indexForInsert = Integer.parseInt(command.split(" ")[2]);
                numbersList.add(indexForInsert, number);
            }
            command = scanner.nextLine();
        }
        for (int number : numbersList) {
            System.out.print(number + " ");
        }

    }
}
