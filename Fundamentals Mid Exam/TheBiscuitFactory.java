package FundamentalsMidExam;

import java.util.Scanner;

public class TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int countOfWorkers = Integer.parseInt(scanner.nextLine());
        int secondFactoryBiscuitsFor30days = Integer.parseInt(scanner.nextLine());

        int firstFactoryBiscuitsPerDay = biscuitsPerDay * countOfWorkers;
        //int firstFactoryBiscuitsFor30days = firstFactoryBiscuitsPerDay * 30;

        //double lessPercentBiscuits = (secondFactoryBiscuitsFor30days - firstFactoryBiscuitsFor30days)/100.0;

        int totalFirstFactoryBiscuits = 0;

        for (int day = 1; day <= 30; day++) {

            if (day % 3 == 0) {
                totalFirstFactoryBiscuits += Math.floor(firstFactoryBiscuitsPerDay * 0.75);
            } else {
                totalFirstFactoryBiscuits += firstFactoryBiscuitsPerDay;
            }
        }
        System.out.printf("You have produced %d biscuits for the past month.%n", totalFirstFactoryBiscuits);
        if (totalFirstFactoryBiscuits > secondFactoryBiscuitsFor30days) {
            int diff = totalFirstFactoryBiscuits - secondFactoryBiscuitsFor30days;
            double diffPercent = (diff * 1.0 / secondFactoryBiscuitsFor30days) * 100;
            System.out.printf("You produce %.2f percent more biscuits.%n", diffPercent);
        } else {
            int diff = secondFactoryBiscuitsFor30days - totalFirstFactoryBiscuits;
            double diffPercent = (diff * 1.0 / secondFactoryBiscuitsFor30days) * 100;
            System.out.printf("You produce %.2f percent less biscuits.%n", diffPercent);
        }
    }
}
