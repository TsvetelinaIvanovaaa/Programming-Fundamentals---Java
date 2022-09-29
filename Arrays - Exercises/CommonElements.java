package Arrays.Exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String firstRow = scanner.nextLine();
        String secondRow = scanner.nextLine();

        String [] firstArray = firstRow.split(" ");
        String [] secondArray = secondRow.split(" ");

        //обхождаме всеки елемент във втория масив
        for (String secondElement : secondArray) {
            //какво повтаряме за всеки елемент от втория масив: обхождаме първия масив
            for (String firstElement : firstArray) {
                if(firstElement.equals(secondElement)){
                    System.out.print(firstElement + " ");
                    break;
                }
            }
        }
    }
}

    //String [] firstArr = scanner.nextLine().split(" ");
    //String [] secondArr = scanner.nextLine().split(" ");

    //secondArr.iter изкарва foreach цикъла за посочения масив
        //for (String secondElement : secondArr) {
                //iterate firstArr
                //for (String firstElement : firstArr) {
                //if(secondElement.equals(firstElement)){
                //System.out.print(firstElement + " ");


