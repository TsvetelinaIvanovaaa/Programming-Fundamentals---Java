package RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int messagesNumber = Integer.parseInt(scanner.nextLine());
        Map<Integer, List<String>> attackedPlanets = new LinkedHashMap();
        Map<Integer, List<String>> destroyedPlanets = new LinkedHashMap();

        int count = 0;
        for (int i = 1; i <= messagesNumber; i++) {
            String text = scanner.nextLine();
            char[] textArr = text.toCharArray();
            int countKey = 0;
            for (int j = 0; j < textArr.length; j++) {
                char currentSymbol = textArr[j];

                if (currentSymbol == 's' || currentSymbol == 't' || currentSymbol == 'a' || currentSymbol == 'r'
                        || currentSymbol == 'S' || currentSymbol == 'T' || currentSymbol == 'A' || currentSymbol == 'R') {
                    countKey++;
                }
            }
            StringBuilder encryptedMessage = new StringBuilder();
            char encryptedSymbol = 0;
            for (int j = 0; j < textArr.length; j++) {

                char currentSymbol = textArr[j];
                int currentSymbolAscii = (int) currentSymbol - countKey;
                encryptedSymbol = (char) currentSymbolAscii;
                encryptedMessage.append(encryptedSymbol);
            }
            String massage = encryptedMessage.toString();
            String regex = "\\@(?<planetName>[A-za-z]+)[^\\@\\-\\!\\:\\>]*\\:(?<planetPopulation>[0-9]+)[^\\@\\-\\!\\:\\>]*\\!(?<attackType>[A-Z])\\!\\-\\>(?<soldierCount>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(massage);

            while (matcher.find()) {
                String planetName = matcher.group("planetName");
                int planetPopulation = Integer.parseInt(matcher.group("planetPopulation"));
                String attackType = matcher.group("attackType");
                int soldierCount = Integer.parseInt(matcher.group("soldierCount"));


                if (attackType.equals("A")) {
                    count++;
                    if (count == 1) {
                        attackedPlanets.put(count, new ArrayList<>());
                        attackedPlanets.get(1).add(planetName);
                    } else {
                        attackedPlanets.get(count + 1).add(planetName);
                    }
                } else if (attackType.equals("D")) {
                    count++;
                    if (count == 1) {
                        destroyedPlanets.put(count, new ArrayList<>());
                        destroyedPlanets.get(1).add(planetName);
                    } else {
                        destroyedPlanets.get(count + 1).add(planetName);
                    }
                }
            }
        }
        //companies.entrySet()
        //                .forEach(company -> {
        //                    System.out.println(company.getKey());
        //                    company.getValue().forEach(employee -> System.out.println("-- " + employee));
        //                });
        attackedPlanets.entrySet()
                .forEach(planet -> {
                    System.out.println("Attacked planets: " + planet.getKey());
                    planet.getValue().forEach(planetName -> System.out.println("-> " + planetName));
                });

    }
}