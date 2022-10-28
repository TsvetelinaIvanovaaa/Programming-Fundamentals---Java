package List.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //1.списък от цели числа - входни данни
        //2.въвеждаме команди -> спираме: "End"
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            //валидна команда
            if (command.contains("Add")) {
                //Add {number} - add number at the end
                int numberToAdd = Integer.parseInt(command.split("\\s+")[1]);
                numbersList.add(numberToAdd);
            } else if (command.contains("Insert")) {
                // Insert {number} {index} - insert number at given index
                int numberToInsert = Integer.parseInt(command.split("\\s+")[1]);
                int index = Integer.parseInt(command.split("\\s+")[2]);
                //проверка дали съществъва индекса в моя списък(index)
                if (isValidIndex(index, numbersList)) {
                    numbersList.add(index, numberToInsert);
                } else {
                    //невалиден индекс
                    System.out.println("Invalid index");
                }
            } else if (command.contains("Remove")) {
                //Remove {index} - remove that index
                int indexForRemove = Integer.parseInt(command.split("\\s+")[1]);
                //проверка дали съществъва индекса в моя списък(indexForRemove)
                if (isValidIndex(indexForRemove, numbersList)) {
                    numbersList.remove(indexForRemove);
                } else {
                    //невалиден индекс
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left")) {
                //Shift left {count} - first number becomes last 'count' times
                int countShiftLeft = Integer.parseInt(command.split("\\s+")[2]);
                //повтаряме нещо count shift left пъти
                for (int time = 1; time <= countShiftLeft; time++) {
                    //first number becomes last
                    //{3, 4, 6, 7, 1}
                    //1.взимам първото число от списъка -> индекс 0
                    int firstNumber = numbersList.get(0);
                    //премахвам по индекс първотъо число от списъка -> {4,6,7,1}
                    numbersList.remove(0);
                    //добавям го накрая на списъка {4, 6, 7, 1, 3}
                    numbersList.add(firstNumber);
                }
            } else if (command.contains("Shift right")) {
                //Shift right {count} - last number becomes first 'count' times
                int countShiftRight = Integer.parseInt(command.split("\\s+")[2]);
                for (int time = 1; time <= countShiftRight; time++) {
                    //last number becomes first
                    //{3, 4, 6, 7, 1}
                    //1.взимам последното число от списъка -> index = size-1
                    int lastNumber = numbersList.get(numbersList.size() - 1);
                    //премахваме последното число от списъка
                    numbersList.remove(numbersList.size() - 1);
                    //добавям го в началото на списъка
                    numbersList.add(0, lastNumber);
                }
            }

            command = scanner.nextLine();
        }
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
    }

    //метод, който проверява дали даден индекс е валиден
    //true -> валиден индекс -> [0, size-1]
    //false -> невалиден индекс
    public static boolean isValidIndex(int index, List<Integer> numbers) {
        return index >= 0 && index <= numbers.size() - 1;
    }
}
