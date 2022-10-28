package FundamentalsMidExamPreparation;

import java.util.Scanner;
import java.util.Arrays;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine()
                        .split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        int countTarget = 0;
        while (!command.equals("End")) {
            int shotIndex = Integer.parseInt(command);
            int currentTarget = 0;
            if (shotIndex >= 0 && shotIndex <= targets.length - 1) {
                countTarget ++;
                currentTarget = targets[shotIndex];
                targets[shotIndex] = -1;

                for (int i = 0; i < targets.length; i++) {
                    int currentNumber = targets[i];
                    if (currentNumber < 0) {
                        continue;
                    }else if(currentNumber > currentTarget){
                        targets[i] -= currentTarget;
                    }else if(currentNumber <= currentTarget){
                        targets[i] += currentTarget;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",countTarget);
        for (int number : targets) {
            System.out.print(number + " ");
        }
    }
}
