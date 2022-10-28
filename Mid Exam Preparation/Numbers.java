package FundamentalsMidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer>newNumbersList = new ArrayList<>();

        int sum = 0;
        double averageNumber = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            sum = sum + numbersList.get(i);
        }
        averageNumber = sum * 1.0/ numbersList.size();

        double finalAverageNumber = averageNumber;
        numbersList.removeIf(e -> e <= finalAverageNumber);

        Collections.sort(numbersList, Collections.reverseOrder());
        if(numbersList.size() >= 5){
            for (int i = 0; i < numbersList.size(); i++) {
                if(i > 4){
                    numbersList.remove(i);
                    i--;
                }
            }
        }
        if(numbersList.size() == 0) {
            System.out.println("No");
        } else{
            System.out.println(numbersList.toString().replaceAll("[\\[\\],]",""));
        }

    }
}
