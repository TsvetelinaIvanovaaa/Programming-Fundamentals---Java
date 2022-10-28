package List.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int removedElementSum = 0;
        while (numbersList.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index <= numbersList.size() - 1) {
                int removedNumber = numbersList.get(index);
                removedElementSum += removedNumber;
                numbersList.remove(index);
                modifyList(numbersList, removedNumber);
            } else if (index < 0) {
                int firstNumber = numbersList.get(0);
                removedElementSum += firstNumber;
                numbersList.remove(0);
                int lastNumber = numbersList.get(numbersList.size()-1);
                numbersList.add(0, lastNumber);
                modifyList(numbersList, firstNumber);
            } else if (index > numbersList.size() - 1) {
                int lastNumber = numbersList.get(numbersList.size() - 1);
                removedElementSum += lastNumber;
                numbersList.remove(numbersList.size() - 1);
                int firstNumber = numbersList.get(0);
                numbersList.add(firstNumber);
                modifyList(numbersList, lastNumber);
            }


        }
        System.out.println(removedElementSum);
    }

    private static void modifyList(List<Integer> numbersList, int removedNumber) {
        for (int i = 0; i < numbersList.size(); i++) {
            int currentNumber = numbersList.get(i);
            if (currentNumber <= removedNumber) {
                currentNumber += removedNumber;
            } else {
                currentNumber -= removedNumber;
            }
            numbersList.set(i, currentNumber);
        }
    }
}
