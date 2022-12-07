package FundamentalsFinalExamPreparation;

import java.util.Scanner;

public class TheImitationGameOK {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();;
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentSymbol = encryptedMessage.charAt(i);
            message.append(currentSymbol);
        }

        String command = scanner.nextLine();
        while(!command.equals("Decode")){
            String[] instructions = command.split("\\|");
            String instructionsType = instructions[0];

            if(instructionsType.equals("Move")){
                int lettersCount = Integer.parseInt(instructions[1]);
                for (int i = 1; i <= lettersCount ; i++) {
                    char currentSymbol = message.charAt(0);
                    message.deleteCharAt(0);
                    message.append(currentSymbol);
                }
            }else if(instructionsType.equals("Insert")){
                int index = Integer.parseInt(instructions[1]);
                String value = instructions[2];
                message.insert(index, value);

            }else if(instructionsType.equals("ChangeAll")){
                char symbol = instructions[1].charAt(0);
                char replaceSymbol = instructions[2].charAt(0);

                for (int i = 0; i < message.length(); i++) {
                    char currentSymbol = message.charAt(i);
                    if(currentSymbol == symbol){
                        int index = i;
                        message.deleteCharAt(i);
                        message.insert(index, replaceSymbol);
                    }
                }

            }


            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n",message);
    }
}
