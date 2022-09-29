package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command = scanner.nextLine();
        double sum = 0;

        while (!"Start".equals(command)) {
            double coins = Double.parseDouble(command);
            if (coins == 0.1) {
                sum += coins;
            } else if (coins == 0.2) {
                sum += coins;
            } else if (coins == 0.5) {
                sum += coins;
            } else if (coins == 1) {
                sum += coins;
            } else if (coins == 2) {
                sum += coins;
            } else {
                System.out.println(String.format("Cannot accept %.2f", coins));
            }
            command = scanner.nextLine();
        }
        String good = scanner.nextLine();
        double price = 0;
        boolean isGood = false;
        while (!"End".equals(good)) {
            switch (good) {
                case "Nuts":
                    price = 2.0;
                    isGood = true;
                    break;
                case "Water":
                    price = 0.7;
                    isGood = true;
                    break;
                case "Crisps":
                    price = 1.5;
                    isGood = true;
                    break;
                case "Soda":
                    price = 0.8;
                    isGood = true;
                    break;
                case "Coke":
                    price = 1.0;
                    isGood = true;
                    break;
            }
            if (sum < price) {
                System.out.println("Sorry, not enough money");
            } else if (isGood) {
                System.out.println(String.format("Purchased %s", good));
                sum -= price;
            } else {
                System.out.println("Invalid product");
            }
            good = scanner.nextLine();
        }
        System.out.println(String.format("Change: %.2f", sum));

    }
}


    //String input = scanner.nextLine();

    //double sumCoins = 0;
        //while(!input.equals("Start")){
                //double coins = Double.parseDouble(input);
                //if(coins == 0.1){
                //sumCoins += coins;
                //}else if(coins == 0.2){
                //sumCoins += coins;
                //}else if(coins == 0.5){
                //sumCoins += coins;
                //}else if(coins == 1){
                //sumCoins += coins;
                //}else if(coins == 2){
                //sumCoins += coins;
                //}else{
                //System.out.printf("Cannot accept %.2f%n",coins);
                //}
                //input = scanner.nextLine();
                //}
                //String item = scanner.nextLine();

                //while (!item.equals("End")){
                //switch (item){
                //case "Nuts":
                //if(sumCoins>=2.0){
                //sumCoins -= 2.0;
                //System.out.printf("Purchased %s%n", item);
                //}else{
                //System.out.println("Sorry, not enough money");
                //break;
                //}
                //break;
                //case "Water":
                //if(sumCoins>=0.7){
                //sumCoins -= 0.7;
                //System.out.printf("Purchased %s%n", item);
                //}else{
                //System.out.println("Sorry, not enough money");
                //break;
                //}
                //break;
                //case "Crisps":
                //if(sumCoins>=1.5){
                //sumCoins -= 1.5;
                //System.out.printf("Purchased %s%n", item);
                //}else{
                //System.out.println("Sorry, not enough money");
                //break;
                //}
                //break;
                //case "Soda":
                //if(sumCoins>=0.8){
                //sumCoins -= 0.8;
                //System.out.printf("Purchased %s%n", item);
                //}else{
                //System.out.println("Sorry, not enough money");
                //break;
                //}
                //break;
                //case "Coke":
                //if(sumCoins>=1.0){
                //sumCoins -=1.0;
                //System.out.printf("Purchased %s%n", item);
                //}else{
                //System.out.println("Sorry, not enough money");
                //break;
                //}
                //break;
         //default:
        //System.out.println("Invalid product");
        //break;
        //}
        //item = scanner.nextLine();
        //}
        //if(sumCoins >= 0){
        //System.out.printf("Change: %.2f", sumCoins);
        //}