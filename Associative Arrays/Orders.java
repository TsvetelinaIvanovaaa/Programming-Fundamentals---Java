package AssociativeArrays.Exercise;

import javax.print.DocFlavor;
import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input = scanner.nextLine();
        //продукт -> обща цена (бр.* ед.цена)
        Map<String, Double> productsPrice = new LinkedHashMap<>(); //продукт -> единична цена
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();//продукт -> брой

        while (!input.equals("buy")){
            String[] productsData = input.split(" ");
            String product = productsData[0];
            double pricePerProduct = Double.parseDouble(productsData[1]);
            int quantity = Integer.parseInt(productsData[2]);

            productsPrice.put(product, pricePerProduct);

            if(!productsQuantity.containsKey(product)){
                productsQuantity.put(product,quantity);
            }else{
                productsQuantity.put(product,productsQuantity.get(product)+quantity);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
            String productName = entry.getKey();
            double finalPrice = entry.getValue() * productsQuantity.get(productName);
            System.out.printf("%s -> %.2f%n",productName, finalPrice);
        }
    }
}
