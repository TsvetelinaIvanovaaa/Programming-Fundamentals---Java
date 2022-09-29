package Arrays.Exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());
        int[] train = new int[wagons];

        for (int i = 0; i < train.length; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
        }
        int allPeople = 0;
        for (int i = 0; i < train.length; i++) {
            allPeople += train[i];
            System.out.print(train[i] + " ");
        }
        System.out.printf("\n%s",allPeople);
    }
}
