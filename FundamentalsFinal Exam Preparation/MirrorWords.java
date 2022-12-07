package FundamentalsFinalExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWordsOK {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1";
        Map<String, String> words = new LinkedHashMap<>();
        Map<String, String> mirrorWordsMap = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while(matcher.find()){
            count++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");

            if(!words.containsKey(wordOne)){
                words.put(wordOne, wordTwo);
            }
        }

        StringBuilder mirrorWord = new StringBuilder();
        for (Map.Entry<String, String> entry : words.entrySet()) {
            mirrorWord.setLength(0);
            String currentWordOne = entry.getKey();
            String currentWordTwo = entry.getValue();

            mirrorWord.append(currentWordOne);
            String mirror = mirrorWord.reverse().toString();

            if(mirror.equals(currentWordTwo)){
                mirrorWordsMap.put(currentWordOne,currentWordTwo);

            }
        }
       if(count > 0){
           System.out.printf("%d word pairs found!%n",count);
       }else{
           System.out.println("No word pairs found!");
       }
       if(mirrorWordsMap.size() > 0){
           System.out.println("The mirror words are:");
           int[] counter = {1};
           mirrorWordsMap.entrySet()
                   .forEach(f -> {
                       System.out.print(String.format("%s <=> %s", f.getKey(), f.getValue()));
                       if(counter[0] < mirrorWordsMap.size()){
                           System.out.print(", ");
                       }
                       counter[0]++;
                   });
       }else {
        System.out.println("No mirror words!");
    }
    }
}
