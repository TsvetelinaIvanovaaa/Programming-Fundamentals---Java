package FundamentalsFinalExamPreparation;

import java.util.Scanner;

public class PasswordResetOK {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text = scanner.nextLine();
        String commandLine = scanner.nextLine();
        while(!commandLine.equals("Done")){
            String[] tokens = commandLine.split(" ");
            String commandType = tokens[0];

            StringBuilder sb = new StringBuilder();
            if(commandType.equals("TakeOdd")){
                for (int i = 0; i < text.length(); i++) {
                    char symbol = text.charAt(i);
                    if(i % 2 != 0){
                        sb.append(symbol);
                    }
                }
                text = sb.toString();
                System.out.printf("%s%n",text);
            }else if(commandType.equals("Cut")){
                int index = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);
                String substring = text.substring(index, index + length);
                text = text.replaceFirst(substring, repeatString("",substring.length()));

                System.out.printf("%s%n",text);
            }else if(commandType.equals("Substitute")){
                String substring = tokens[1];
                String substitute = tokens[2];

                if(text.contains(substring)){
                    text = text.replace(substring, substitute);

                    System.out.printf("%s%n",text);
                }else{
                    System.out.println("Nothing to replace!");
                }
            }
            commandLine = scanner.nextLine();
        }
        System.out.printf("Your password is: %s%n",text);
    }
    public static String repeatString (String s, int length ){
        String result = "";
        for (int i = 0; i < length; i++) {
            result += s;
        }
        return result;
    }
}
