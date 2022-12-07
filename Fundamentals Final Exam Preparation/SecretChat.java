package FundamentalsFinalExamPreparation;

import java.util.Scanner;

public class SecretChatOK {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String concealedMassage = scanner.nextLine();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Reveal")){
            String[]tokans = inputLine.split(":\\|:");
            String commandType = tokans[0];

            StringBuilder sb = new StringBuilder();
            if(commandType.equals("InsertSpace")){
                int index = Integer.parseInt(tokans[1]);
                sb.append(concealedMassage);
                sb.insert(index, " ");
                concealedMassage = sb.toString();
                System.out.printf("%s%n",concealedMassage);
            }else if(commandType.equals("Reverse")){
                String substring = tokans[1];
                if(concealedMassage.contains(substring)){
                    int length = substring.length();
                    String replaceString = "";
                    concealedMassage = concealedMassage.replaceFirst(substring, repeatString("", substring.length()));

                    String reverseString = " ";
                    sb.setLength(0);
                    for (int i = substring.length()-1; i >= 0; i--) {
                        char symbol = substring.charAt(i);
                        sb.append(symbol);
                    }
                    reverseString = sb.toString();
                    sb.setLength(0);
                    sb.append(concealedMassage);
                    sb.append(reverseString);
                    concealedMassage = sb.toString();
                    System.out.printf("%s%n",concealedMassage);
                }else{
                    System.out.println("error");
                }
            }else if(commandType.equals("ChangeAll")){
                String substring = tokans[1];
                String replacement = tokans[2];

                while(concealedMassage.contains(substring)){
                    concealedMassage = concealedMassage.replace(substring, replacement);
                }
                System.out.printf("%s%n",concealedMassage);
            }
            inputLine = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n",concealedMassage);
    }
    public static String repeatString (String s, int count){
        String result = "";
        for (int i = 0; i < count; i++) {
            result += s;
        }
        return result;
    }
}
