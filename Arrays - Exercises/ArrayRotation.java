package Arrays.Exercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        //scanner.nextLine() -> "51 47 32 61 21".split(" ") -> ("51", "41", "32", "61", "21")
        String [] array = scanner.nextLine().split(" ");
        int countRotation = Integer.parseInt(scanner.nextLine());

        for (int rotation = 1; rotation <= countRotation ; rotation++) {
            //ротация на масива
            //1.взимаме първият елемент

            String firstElement = array[0];

            //2.местим всички елементи с едно наляво,обхождаме всички елементи в масива с for-цикъл,
            // без да включваме последния елемнт,защото него не искаме да го премахваме;
            //така се получава : ("41", "32", "61", "21", "21")

            for (int index = 0; index < array.length - 1; index++) {
                array[index] = array[index +1]; //на текущата позиция да ми застане елемнта, който е бил на следващата позиция
            }
            //3.задаваме последния еллемент в масива да е първия
            array[array.length - 1] = firstElement;
        }
        //отпечатваме елементите на масива
        for (String element : array) {
            System.out.print(element + " ");
        }

    }
}


    //String [] array = scanner.nextLine().split(" ");
    //int rotation = Integer.parseInt(scanner.nextLine());

        //for (int i = 0; i < rotation; i++) {
        //String firstElement = array[0];
        //преместваме всички други елементи без първия с едно на ляво
        //for (int j = 0; j < array.length-1; j++) {
        //array[j] = array[j+1];
        //j+1 -> дава ни съседния елемент от масива (следващия елемент)
        //след шифтването взимаме първия елемент и го поставяме на последната позиция
        //array[array.length-1]=firstElement;
        //}
        //System.out.println(String.join(" ",array));