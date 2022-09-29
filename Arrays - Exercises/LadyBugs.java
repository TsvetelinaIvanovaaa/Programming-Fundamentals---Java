package Arrays.MoreExercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] bugPositions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] field = new int[fieldSize];

        //поставяме първоначалните каинки на полето,индекса, на който има калинка отбелязваме с 1.
        for (int i = 0; i < bugPositions.length; i++) {
            int index = bugPositions[i];
            if (index >= 0 && index < field.length) {
                field[index] = 1;
            }
        }
        //четем подадените команди като стринг
        String line = scanner.nextLine();
        while (!line.equals("end")) {
            //създаваме стринг масив, в който запазваме целия низ на командата
            String[] data = line.split(" ");
            int index = Integer.parseInt(data[0]);
            String direction = data[1];
            int flyLength = Integer.parseInt(data[2]);

            if (index < 0 || index >= field.length || field[index] != 1) {
                line = scanner.nextLine();
                continue;
            }
            //в момента, в който преместваме калинката и те отлита,
            //индекса, на който се е намирала първоначално става равен на 0;
            field[index] = 0;
            switch (direction) {
                case "right":
                    //калинката ще лети със зададената по условие дължина flylength
                    index += flyLength;
                    //ще направи опит да лети до получения индекс, но трябва да се провери дали на него няма друга калинка,
                    //ако е зает, тя трябва да кацне на първия свободен индекс или да изхвърчи от полето
                    //летене на калинката
                    while (index < fieldSize && field[index] == 1) {
                        index += flyLength;
                    }
                    //правим проверка дали калинката е още в полето и я приземяваме на съответния индекс
                    if (index < fieldSize) {
                        field[index] = 1;
                    }
                    break;
                case "left":
                    index -= flyLength;
                    //полет
                    while (index >= 0 && field[index] == 1) {
                        index -= flyLength;
                    }
                    //проверка за кацане
                    if (index >= 0) {
                        field[index] = 1;
                    }
                    break;
            }

            line = scanner.nextLine();
        }
        Arrays.stream(field).forEach(e -> System.out.print(e + " "));
    }
}
