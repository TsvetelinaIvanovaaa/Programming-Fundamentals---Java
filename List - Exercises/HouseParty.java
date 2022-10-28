package List.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guestNames = new ArrayList<>();
        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countCommands; i++) {
            String command = scanner.nextLine();
            List<String> commandParts = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            String name = commandParts.get(0);

            if (commandParts.size() == 3) { //GOING
                if (guestNames.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guestNames.add(name);
                }
            }else if(commandParts.size() == 4){
                if (!guestNames.contains(name)) {
                    System.out.printf("%s is not in the list!%n", name);
                } else {
                    guestNames.remove(name);
                }
            }
        }
        for (String name : guestNames) {
            System.out.println(name);
        }
    }
}
