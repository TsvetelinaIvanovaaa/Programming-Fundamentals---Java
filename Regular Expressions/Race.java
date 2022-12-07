package RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String participantsNames = scanner.nextLine();
        List<String> racersList = Arrays.stream(participantsNames.split(", ")).collect(Collectors.toList());

        Map<String, Integer> racersMap = new LinkedHashMap<>();
        racersList.forEach(name -> racersMap.put(name, 0));

        String regexLetters = "[A-Za-z]+";
        Pattern patternLetters = Pattern.compile(regexLetters);

        String regexDigits = "[0-9]";
        Pattern patternDigits = Pattern.compile(regexDigits);

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end of race")) {

            Matcher matcherLetters = patternLetters.matcher(inputLine);
            StringBuilder racerName = new StringBuilder();
            while (matcherLetters.find()) {
                racerName.append(matcherLetters.group());
            }

            Matcher matcherDigits = patternDigits.matcher(inputLine);
            int distance = 0;
            while (matcherDigits.find()) {
                distance += Integer.parseInt(matcherDigits.group());
            }

            if (racersList.contains(racerName.toString())) {
                int currentDistance = racersMap.get(racerName.toString());
                racersMap.put(racerName.toString(), currentDistance + distance);
            }


            inputLine = scanner.nextLine();
        }
        List<String> top3Names = racersMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + top3Names.get(0));
        System.out.println("2nd place: " + top3Names.get(1));
        System.out.println("3rd place: " + top3Names.get(2));
        // int count = 1;
        // for (Map.Entry<String, Integer> entry : racersMap.entrySet()) {
        //     if (count == 1) {
        //         System.out.printf("1st place: %s%n", entry.getKey());
        //         count++;
        //     } else if (count == 2) {
        //         System.out.printf("2nd place: %s%n", entry.getKey());
        //         count++;
        //     }else if(count == 3){
        //         System.out.printf("3rd place: %s%n", entry.getKey());
        //        break;
        //    }
        // }
    }
}
