package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isFound = false;
        // isFound = true -> ако имаме такъв елемент, при който лявата и дясната сума са равни;
        // isFound = false -> ако нямамв такъв елемнт, при който лявата и дясната суми са равни;

        for (int index = 0; index <= numbers.length - 1; index++) {
            //взимаме елемнта на текущия индекс
            int currentElement = numbers[index];
            //за всеки елемнт правим проверка дали сумата на елементите в ляво е = на сумата на елемнтите в дясно
            int leftSum = 0;
            int rightSum = 0;

            //лявата сума -> всички елемнти от индекс 0 до моя(текущия) индекс не вклщчително
            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                leftSum += numbers[leftIndex];
            }
            //дясна сума -> всички елемнти след моя(текущия) индекс е + 1 до последния
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {
                rightSum += numbers[rightIndex];
            }
            //проверка дали лявата и дясната суми са равни
            if (leftSum == rightSum) {
                System.out.println(index);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}
