package FundamentalsFinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapperOK {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String mapPlaces = scanner.nextLine();
        List<String> locationsList = new ArrayList<>();

        String regex = "([=/])(?<location>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(mapPlaces);

        int sumLength = 0;
        while(matcher.find()){
            String location = matcher.group("location");
            sumLength += location.length();

            locationsList.add(location);
        }
        System.out.print("Destinations: ");
        System.out.print(String.join(", ",locationsList));
        System.out.println();
        System.out.printf("Travel Points: %d%n",sumLength);
    }
}
