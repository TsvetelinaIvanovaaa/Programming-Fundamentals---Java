package ExamPreparation;

import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int firstPlayerEgs=Integer.parseInt(scanner.nextLine());
        int secontPlayerEgs=Integer.parseInt(scanner.nextLine());

        String command=scanner.nextLine();
        boolean isSecondWin = false;
        boolean isFirstWin = false;
        while (!command.equals("End")){
            switch ((command)){
                case "one":
                    secontPlayerEgs--;
                    break;
                case "two":
                    firstPlayerEgs--;
                    break;
            }
            if(firstPlayerEgs==0){
                isSecondWin = true;
                break;
            }
            if(secontPlayerEgs==0){
                isFirstWin = true;
                break;
            }
            command=scanner.nextLine();
        }
        if(isSecondWin){
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.",secontPlayerEgs);
        }else if(isFirstWin){
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.",firstPlayerEgs);
        }else{
            System.out.printf("Player one has %d eggs left.%n",firstPlayerEgs);
            System.out.printf("Player two has %d eggs left.",secontPlayerEgs);
        }
    }
}
