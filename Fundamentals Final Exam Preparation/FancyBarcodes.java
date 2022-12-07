package FundamentalsFinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodesOK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countBarcodes = Integer.parseInt(scanner.nextLine());
        List<String> allBarcodes = new ArrayList<>();
        List<String> renamedBarcodes = new ArrayList<>();
        for (int i = 1; i <= countBarcodes ; i++) {
            String barcodeData = scanner.nextLine();
            allBarcodes.add(barcodeData);
        }

        for (int i = 0; i < allBarcodes.size(); i++) {
            String currentBarcode = allBarcodes.get(i);
            String regex = "^@#+(?<barcodeInfo>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(currentBarcode);
            if (matcher.find()) {
                String barcode = matcher.group("barcodeInfo");
                renamedBarcodes.add(barcode);
            } else {
                String invalidBarcode = "Invalid barcode";
                renamedBarcodes.add(invalidBarcode);
            }
        }

        StringBuilder productGroup = new StringBuilder();
        List<String> productGroupList = new ArrayList<>();

        for (int i = 0; i < renamedBarcodes.size(); i++) {
            productGroup.setLength(0);
            String currentBarcode = renamedBarcodes.get(i);

            if(currentBarcode.contains("Invalid barcode")){
                productGroupList.add(currentBarcode);
                continue;
            }
            for (int j = 0; j < currentBarcode.length(); j++) {
                char symbol = currentBarcode.charAt(j);

                if (Character.isDigit(symbol)) {
                    productGroup.append(symbol);
                }
            }
            if (productGroup.length() == 0) {
                String barcodeItem = "00";
                productGroupList.add(barcodeItem);
            } else {
                productGroupList.add(productGroup.toString());
            }
        }
        for (int i = 0; i < productGroupList.size(); i++) {
            String currentItem = productGroupList.get(i);
            if(currentItem.contains("Invalid barcode")) {
                System.out.println("Invalid barcode");
            }else{
                System.out.printf("Product group: %s%n", currentItem);
            }
        }
    }
}