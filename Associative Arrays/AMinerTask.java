package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> minerMap = new LinkedHashMap<>();
        int count = 1;
        String resource = " ";
        int quantity = 0;
        while (!command.equals("stop")) {
            quantity = 0;
            if (count % 2 != 0) {
                resource = command;
            } else {
                quantity = Integer.parseInt(command);
            }

            if (!minerMap.containsKey(resource)) {
                minerMap.put(resource, 0);
            } else {
                minerMap.put(resource, minerMap.get(resource) + quantity);
            }
            count++;
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : minerMap.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
