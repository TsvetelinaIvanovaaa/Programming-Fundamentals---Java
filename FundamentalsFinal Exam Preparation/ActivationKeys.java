package FundamentalsFinalExamPreparation;

import java.util.Scanner;

public class ActivationKeysOK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String instructions = scanner.nextLine();
        while (!instructions.equals("Generate")){
            String[] tokens = instructions.split(">>>");
            String command = tokens[0];
            if(command.equals("Contains")){
                String substring = tokens[1];
                if(activationKey.contains(substring)){
                    System.out.printf("%s contains %s%n",activationKey, substring);
                }else{
                    System.out.println("Substring not found!");
                }
            }else if(command.equals("Flip")){
                String symbolType = tokens[1];
                int startIndex = Integer.parseInt(tokens[2]);
                int endIndex = Integer.parseInt(tokens[3]);
                String substring = activationKey.substring(startIndex, endIndex);
                if(symbolType.equals("Upper")){
                    activationKey = activationKey.replace(substring, substring.toUpperCase());
                    System.out.printf("%s%n",activationKey);
                }else if(symbolType.equals("Lower")){
                    activationKey = activationKey.replace(substring, substring.toLowerCase());
                    System.out.printf("%s%n",activationKey);
                }
            }else if(command.equals("Slice")){
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                String substring = activationKey.substring(startIndex, endIndex);
                activationKey = activationKey.replaceAll(substring, "");
                System.out.printf("%s%n",activationKey);
            }

            instructions = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n",activationKey);
    }
}
