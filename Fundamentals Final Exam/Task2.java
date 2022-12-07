package FundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        String regex = "[@|#]+(?<eggColor>[a-z]{3,})[@|#]+(\\W*)/+(?<eggAmount>[0-9]+)/+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()){
            String eggColor = matcher.group("eggColor");
            int eggAmount = Integer.parseInt(matcher.group("eggAmount"));

            sb.append(String.format("You found %d %s eggs!%n",eggAmount,eggColor ));
        }
        System.out.println(sb.toString());
    }
}
