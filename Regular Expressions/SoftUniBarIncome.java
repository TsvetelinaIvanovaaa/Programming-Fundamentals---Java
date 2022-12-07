package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String inputLine = scanner.nextLine();
        String regex = "%(?<customer>[A-Z]+[a-z]+)\\%[^\\|\\$\\%\\.]*\\<(?<product>\\w+)\\>[^\\|\\$\\%\\.]*\\|(?<count>[0-9]+)\\|[^\\|\\$\\%\\.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);


        double incomes = 0;
        while(!inputLine.equals("end of shift")){

            Matcher matcher = pattern.matcher(inputLine);
            while(matcher.find()){
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double totalPrice = count * price;
                incomes += totalPrice;

                System.out.printf("%s: %s - %.2f%n",customer, product, totalPrice);
            }
            inputLine = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", incomes);
    }
}
