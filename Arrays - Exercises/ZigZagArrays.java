package Arrays.Exercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой редове;
        int [] firstArray = new int[n];
        int [] secondArray = new int[n];

        for (int row = 1; row <= n ; row++) {
            String numbers = scanner.nextLine();
            int firstNumber = Integer.parseInt(numbers.split("")[0]);
            int secondNumber = Integer.parseInt(numbers.split(" ")[1]);

            //ако имаме четен ред - първото число отива във втори масив, а второто число отива в първи масив;
            //ако имаме нечетен ред - първото число отива в първи масив, а второрото число отива във втори масив;
            if(row % 2 == 0){
                firstArray[row-1] = secondNumber;
                secondArray[row-1] = firstNumber;
            }else{
                firstArray[row-1] = firstNumber;
                secondArray[row-1] = secondNumber;
            }
        }
        //отпечатваме елементите на първия масив;
        for (int number : firstArray) {
            System.out.print(number + " ");
        }

        System.out.println();
        //отпечатваме елементите на втория масив;
        for (int number : secondArray) {
            System.out.print(number + " ");
        }
    }
}

    //int n = Integer.parseInt(scanner.nextLine());
    //String [] firstArr = new String[n];
    //String [] secondArr = new String[n];

        //for (int i = 1; i <= n; i++) {
                //String[] line = scanner.nextLine().split(" ");
                //if (i % 2 != 0){
                //firstArr [i -1] = line [1];
                //secondArr [i -1] = line[0];
                //}
                //}
                //for (int i = 0; i < firstArr.length; i++) {
        //System.out.print(firstArr[i] + " ");
        //}
        //for (int i = 0; i < secondArr.length; i++) {
        //System.out.print(secondArr[i] + " ");
       //}


//for (int i = 1; i <= n; i++) {
        //String[] line = scanner.nextLine().split(" ");
        //if (i % 2 != 0){
        //firstArr [i -1] = line [1];
        //secondArr [i -1] = line[0];
        //}else{
        //firstArr [i - 1] = line[1];
        //secondArr [i - 1] = line[0];
        //}
        //}
        //System.out.println(String.join(" ",firstArr));
        //System.out.println(String.join(" ",secondArr));