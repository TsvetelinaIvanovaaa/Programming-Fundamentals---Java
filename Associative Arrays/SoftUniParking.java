package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandCount = Integer.parseInt(scanner.nextLine());
        Map<String, String> usersMap = new LinkedHashMap<>();

        for (int i = 0; i < commandCount; i++) {
            String userData = scanner.nextLine();
            String commandType = userData.split(" ")[0];

            if (commandType.equals("register")) {
                String username = userData.split(" ")[1];
                String licensePlateNumber = userData.split(" ")[2];
                if (!usersMap.containsKey(username)) {
                    usersMap.put(username, licensePlateNumber);
                    System.out.println(username + " registered " + licensePlateNumber + " successfully");
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n",licensePlateNumber);
                }
            } else if (commandType.equals("unregister")) {
                String username = userData.split(" ")[1];
                if(!usersMap.containsKey(username)){
                    System.out.printf("ERROR: user %s not found%n",username);
                }else{
                    System.out.println(username + " unregistered successfully");
                    usersMap.remove(username);
                }
            }
        }
        for (Map.Entry<String, String> entry : usersMap.entrySet()) {
            System.out.printf("%s => %s%n",entry.getKey(),entry.getValue());
        }

    }
}
