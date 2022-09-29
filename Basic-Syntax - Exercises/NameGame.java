package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String name = scanner.nextLine();
        String winner = " ";
        int points = 0;
        int maxPoints = 0;
        boolean isSecondWins = false;

        while (!name.equals("Stop")){
            points = 0;
            for (int i = 0; i < name.length() ; i++) {
                int num = Integer.parseInt(scanner.nextLine());
                    char symbol = name.charAt(i);
                    int digit = (int)symbol;

                    if(num == digit){
                        points += 10;
                    }else{
                        points += 2;
                    }
            }
            if(points > maxPoints){
                maxPoints = points;
                winner = name;
            }
            if(points == maxPoints){
                isSecondWins = true;
                winner = name;
            }
            name = scanner.nextLine();
        }
        if(isSecondWins){
            System.out.printf("The winner is %s with %d points!",winner,maxPoints);
        }else{
            System.out.printf("The winner is %s with %d points!",winner,maxPoints);
        }

    }
}
