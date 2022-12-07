package FundamentalsFinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetectorOK {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text = scanner.nextLine();
        List<String> emojiList = new ArrayList<>();
        List<String> coolEmojiList = new ArrayList<>();

        String emojiRegex = "(?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))";
        String numberRegex = "\\d";

        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Pattern numberPattern = Pattern.compile(numberRegex);

        Matcher emojiMatcher = emojiPattern.matcher(text);
        Matcher numberMatcher = numberPattern.matcher(text);

        int coolThreshold = 1;
        while (numberMatcher.find()){
            int digit = Integer.parseInt(numberMatcher.group());
            coolThreshold *= digit;
        }

        int emojiCount = 0;
        while (emojiMatcher.find()){
            //String start = emojiMatcher.group("start");
            String emoji = emojiMatcher.group("name");
            emojiCount ++;
            //String finalEmoji = start + emoji + start;
            emojiList.add(emoji);
        }

        for (int i = 0; i < emojiList.size(); i++) {
            String currentEmoji = emojiList.get(i);

            int asciiSum = 0;
            int ascii = 0;
            char currentSymbol = 0;
            for (int j = 0; j < currentEmoji.length(); j++) {
                currentSymbol = currentEmoji.charAt(j);
                if (currentSymbol == 42 || currentSymbol == 58) {
                    continue;
                }else{
                    ascii = (int)currentSymbol;
                    asciiSum += ascii;
                }
            }
            if(asciiSum > coolThreshold){
                coolEmojiList.add(currentEmoji);
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCount);

        for (String emoji : coolEmojiList) {
            System.out.println(emoji );
        }
    }
}
