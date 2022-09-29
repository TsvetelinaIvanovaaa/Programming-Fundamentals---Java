package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //number of people
        int p = Integer.parseInt(scanner.nextLine()); //capacity

        int courses = 0;

        if ( n > p){
            if ( n % p == 0){
                courses = n / p;
                System.out.println(courses);
            }else{
                courses = n/ p;
                courses = courses + 1;

                System.out.println(courses);
            }

        }else{
            System.out.println(1);
        }

    }
}
