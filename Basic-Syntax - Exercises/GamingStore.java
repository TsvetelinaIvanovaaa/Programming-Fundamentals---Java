package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double spent = 0;
        double price = 0;

        String input = scanner.nextLine();
        while (!input.equals("Game Time")){

            if(input.equals("OutFall 4")){
                price = 39.99;
                if(currentBalance<price){
                    System.out.println("Too Expensive");
                }else{
                    currentBalance -= price;
                    spent += 39.99;
                    System.out.println("Bought OutFall 4");
                }
            }else if(input.equals("CS: OG")){
                price = 15.99;
                if(currentBalance<price){
                    System.out.println("Too Expensive");
                }else{
                    currentBalance -= price;
                    spent += 15.99;
                    System.out.println("Bought CS: OG");
                }
            }else if(input.equals("Zplinter Zell")){
                price = 19.99;
                if(currentBalance<price){
                    System.out.println("Too Expensive");
                }else{
                    currentBalance -= price;
                    spent += 19.99;
                    System.out.println("Bought Zplinter Zell");
                }
            }else if(input.equals("Honored 2")){
                price = 59.99;
                if(currentBalance<price){
                    System.out.println("Too Expensive");
                }else{
                    currentBalance -= price;
                    spent += 59.99;
                    System.out.println("Bought Honored 2");
                }
            }else if(input.equals("RoverWatch")){
                price = 29.99;
                if(currentBalance<price){
                    System.out.println("Too Expensive");
                }else{
                    currentBalance -= price;
                    spent += 29.99;
                    System.out.println("Bought RoverWatch");
                }
            }else if (input.equals("RoverWatch Origins Edition")){
                price = 39.99;
                if(currentBalance<price){
                    System.out.println("Too Expensive");
                }else{
                    currentBalance -= price;
                    spent += 39.99;
                    System.out.println("Bought RoverWatch Origins Edition");
                }
            }else{
                System.out.println("Not Found");
            }

            input =scanner.nextLine();
        }
        if(currentBalance <= 0){
            System.out.println("Out of money!");
        }else{
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f",spent,currentBalance);
        }

    }
}
