package FundamentalsFinalExamPreparation;

import java.util.Scanner;

public class WorldTourOK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        StringBuilder stopsData = new StringBuilder();

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Travel")) {
            String[] tokens = commandLine.split(":");
            String commandType = tokens[0];

            if (commandType.contains("Add")) {
                int index = Integer.parseInt(tokens[1]);
                String text = tokens[2];

                StringBuilder sb = new StringBuilder();
                sb.append(stops);
                if (index >= 0 && index < stops.length()) {
                    sb.insert(index, text);
                    stops = sb.toString();
                    stopsData.append(String.format("%s%n", stops));
                } else {
                    stopsData.append(String.format("%s%n", stops));
                }

            } else if (commandType.contains("Remove")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);

                if (startIndex >= 0 && startIndex < stops.length() &&
                        endIndex >= 0 && endIndex < stops.length()) {
                    String substring = stops.substring(startIndex, endIndex + 1);
                    stops = stops.replace(substring, "");
                    stopsData.append(String.format("%s%n", stops));
                } else {
                    stopsData.append(String.format("%s%n", stops));
                }

            } else if (commandType.contains("Switch")) {
                String oldString = tokens[1];
                String newString = tokens[2];

                if (stops.contains(oldString)) {
                    stops = stops.replaceAll(oldString, newString);
                    stopsData.append(String.format("%s%n", stops));
                } else {
                    stopsData.append(String.format("%s%n", stops));
                }
            }
            commandLine = scanner.nextLine();
        }
        System.out.print(stopsData);
        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }
}
