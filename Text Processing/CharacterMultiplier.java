package TextProcessing.Exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] data = input.split(" ");

        String firstText = data[0];
        String secondText = data[1];

        System.out.println(MultiplyCharacters(data[0],data[1]));

    }
    public static int MultiplyCharacters (String firstText, String secondText){
        char[] firstWordArray = firstText.toCharArray();
        char[] secondWordArray = secondText.toCharArray();

        int totalSum = 0;
        int product = 0;

        int shorterWord = Math.min(firstWordArray.length,secondWordArray.length);
        int longestWord = Math.max(firstWordArray.length,secondWordArray.length);

        for (int i = 0; i < shorterWord; i++){
            product=(int)firstWordArray[i]*(int)secondWordArray[i];
            totalSum += product;
        }

        if(firstWordArray.length<secondWordArray.length){
            for (int i = shorterWord; i <= longestWord-1; i++){
                totalSum+=secondWordArray[i];
            }
        } else if (firstWordArray.length>secondWordArray.length){
            for (int i = shorterWord; i <= longestWord-1; i++){
                totalSum+=firstWordArray[i];
            }
        }
        return totalSum;
    }

}
