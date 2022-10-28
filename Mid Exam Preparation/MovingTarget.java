package FundamentalsMidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandType = command.split(" ");
            String currentCommand = commandType[0];
            if (currentCommand.contains("Shoot")) {
                int shotIndex = Integer.parseInt(commandType[1]);
                int power = Integer.parseInt(commandType[2]);

                if (shotIndex >= 0 && shotIndex <= targetsList.size() - 1) {
                    int shotElement = targetsList.get(shotIndex);
                    if (shotElement == 0 || power >= shotElement) {
                        targetsList.remove(shotIndex);
                    } else {
                        targetsList.set(shotIndex, shotElement - power);
                    }

                }
            } else if (currentCommand.contains("Add")) {
                int addIndex = Integer.parseInt(commandType[1]);
                int addValue = Integer.parseInt(commandType[2]);

                if (addIndex >= 0 && addIndex <= targetsList.size() - 1) {
                    targetsList.add(addIndex, addValue);
                } else {
                    System.out.println("Invalid placement!");
                }
            } else if (currentCommand.contains("Strike")) {
                int strikeIndex = Integer.parseInt(commandType[1]);
                int strikeRadius = Integer.parseInt(commandType[2]);
                int strikeLeftRadius = strikeIndex - strikeRadius;
                int strikeRightRadius = strikeIndex + strikeRadius;

                if (strikeIndex >= 0 && strikeIndex <= targetsList.size() - 1 && strikeLeftRadius >= 0 &&
                        strikeLeftRadius <= targetsList.size() - 1 && strikeRightRadius >= 0 &&
                        strikeRightRadius <= targetsList.size() - 1) {
                    targetsList.subList(strikeLeftRadius, strikeRightRadius + 1).clear();

                } else {
                    System.out.println("Strike missed!");
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < targetsList.size(); i++) {
            if (i == targetsList.size() - 1) {
                System.out.print(targetsList.get(i));
            } else {
                System.out.print(targetsList.get(i) + "|");
            }
        }

    }
}
