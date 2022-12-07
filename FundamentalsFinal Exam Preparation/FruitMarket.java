package ExamPreparation;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double strawberriesPrice=Double.parseDouble(scanner.nextLine());
        double bananasQuantity=Double.parseDouble(scanner.nextLine());
        double orangesQuantyti=Double.parseDouble(scanner.nextLine());
        double raspberriesQuantyti=Double.parseDouble(scanner.nextLine());
        double strawberriesQuantyti=Double.parseDouble(scanner.nextLine());

        double raspberriesPrice=strawberriesPrice*0.50;
        double orangesPrice=raspberriesPrice-(raspberriesPrice*0.40);
        double bananasPrice=raspberriesPrice-(raspberriesPrice*0.80);

        double totalPrice=strawberriesPrice*strawberriesQuantyti+
                raspberriesPrice*raspberriesQuantyti+
                orangesPrice*orangesQuantyti+
                bananasPrice*bananasQuantity;

        System.out.printf("%.2f",totalPrice);
    }
}
