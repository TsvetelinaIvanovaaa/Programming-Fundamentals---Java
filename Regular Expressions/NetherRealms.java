package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String demonData = scanner.nextLine();

        String healthRegex = "[A-Za-z]";
        Pattern healthPattern = Pattern.compile(healthRegex);
        Matcher healthMatcher = healthPattern.matcher(demonData);

        int demonHealth = 0;
        while(healthMatcher.find()){
            String matchSymbol = healthMatcher.group();
            char symbol = matchSymbol.charAt(0);
            demonHealth += (int)symbol;
        }

        String damageRegex = "(-)*([0-9]\\.*[0-9]*)+(\\*)*(/)*";
        Pattern damagePattern = Pattern.compile(damageRegex);
        Matcher damageMatcher = damagePattern.matcher(demonData);

        double demonDamage = 0;
        while (damageMatcher.find()){
            String matchSymbol = damageMatcher.group();

            //char symbol = matchSymbol.charAt(0);
            if(matchSymbol.equals("*")){
                demonDamage *= 2;
            }else if(matchSymbol.equals("/")) {
                demonDamage /= 2;
            }else if(matchSymbol.contains("-")){
                double digit = Math.abs(Double.parseDouble(matchSymbol));
                demonDamage -= digit;
            }else{
                double digit = Double.parseDouble(matchSymbol);
                demonDamage += digit;
            }

        }

    }
}
