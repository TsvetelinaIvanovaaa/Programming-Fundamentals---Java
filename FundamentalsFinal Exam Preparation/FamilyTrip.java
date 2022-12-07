package ExamPreparation;

import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double budget=Double.parseDouble(scanner.nextLine());
        int nights=Integer.parseInt(scanner.nextLine());
        double pricePerNight=Double.parseDouble(scanner.nextLine());
        int percentExpenses=Integer.parseInt(scanner.nextLine());

        if(nights>7){
            pricePerNight*=0.95;
        }
        double accommodation=nights*pricePerNight;
        double expenses=budget*percentExpenses/100;

        double neededMoney=accommodation+expenses;
        if(budget>=neededMoney){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.",budget-neededMoney);
        }else{
            System.out.printf("%.2f leva needed.",neededMoney-budget);
        }
    }
}
