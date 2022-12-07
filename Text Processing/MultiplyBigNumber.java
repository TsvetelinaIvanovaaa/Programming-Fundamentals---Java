package TextProcessing.Exercise;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] inputNum = scanner.nextLine().toCharArray();
        int multiplier = Integer.parseInt(scanner.nextLine());

        StringBuilder exitNum = new StringBuilder();

        int addNum = 0;
        for (int i = inputNum.length - 1; i >= 0; i--) {
            int currentNum = ((inputNum[i] - '0') * multiplier) + addNum;
            exitNum.append(currentNum % 10);
            addNum = currentNum / 10;
        }

//if (addNum > 0) {
        exitNum.append(addNum);
//}

        exitNum.reverse();
        while (exitNum.charAt(0) == '0' && exitNum.length() > 1) {
            exitNum.deleteCharAt(0);
        }
        System.out.println(exitNum);
    }
}
