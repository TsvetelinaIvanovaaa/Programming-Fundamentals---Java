package RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String inputLine = scanner.nextLine();

        String regex = ">>(?<furniture>[A-Z]+[a-z]*)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> furnitureNameList = new ArrayList<>();


        double totalSpendMoney = 0;
        while(!inputLine.equals("Purchase")){

            Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()){
                String furnitureName = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnitureNameList.add(furnitureName);

                double totalPrice = price * quantity;
                totalSpendMoney += totalPrice;
            }


            inputLine = scanner.nextLine();
        }
        System.out.println("Bought furniture:");

        for (String name : furnitureNameList) {
            System.out.printf("%s%n", name);
        }
        System.out.printf("Total money spend: %.2f", totalSpendMoney);
    }
}
