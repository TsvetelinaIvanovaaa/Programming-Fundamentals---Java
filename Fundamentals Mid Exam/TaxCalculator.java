package FundamentalsMidExam;

import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicles = scanner.nextLine().split(">>");


        double totalTaxCollected = 0;
        String car = " ";
        for (int i = 0; i < vehicles.length; i++) {

            String currentCar = vehicles[i];
            String[] carInformation = currentCar.split(" ");
            double totalTax = 0;
            String carType = carInformation[0];
            if (carType.contains("family")) {
                int years = Integer.parseInt(carInformation[1]);
                int kilometers = Integer.parseInt(carInformation[2]);

                totalTax = kilometers / 3000 * 12 + (50 - years * 5);
                totalTaxCollected += totalTax;

                System.out.printf("A family car will pay %.2f euros in taxes.%n",totalTax);

            } else if (carType.contains("heavyDuty")) {
                int years = Integer.parseInt(carInformation[1]);
                int kilometers = Integer.parseInt(carInformation[2]);

                totalTax = kilometers / 9000 * 14 + (80 - years * 8);
                totalTaxCollected += totalTax;

                System.out.printf("A heavyDuty car will pay %.2f euros in taxes.%n",totalTax);

            } else if (carType.contains("sports")) {
                int years = Integer.parseInt(carInformation[1]);
                int kilometers = Integer.parseInt(carInformation[2]);

                totalTax = kilometers / 2000 * 18 + (100 - years * 9);
                totalTaxCollected += totalTax;

                System.out.printf("A sports car will pay %.2f euros in taxes.%n",totalTax);
            } else {
                System.out.println("Invalid car type.");
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n",totalTaxCollected);
    }
}
