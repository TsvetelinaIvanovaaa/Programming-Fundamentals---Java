package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int source = Integer.parseInt(scanner.nextLine()); //брой подправки в полето
        //повтаряме всеки дне добив = yield- 26 и намаляме силата на полето с 10
        //спираме когато броя на подправките стане < 100
        //продължаваме докато бр на подправките е >= 100

        int days = 0;
        int totalAmountSpices = 0; //общо количество добити подправки
        while(source >= 100){
            int spices = source - 26; //добив
            totalAmountSpices += spices;
            days ++;
            source = source - 10;

        }
        System.out.println(days);
        if(totalAmountSpices >= 26){
            totalAmountSpices -= 26;
        }
        System.out.println(totalAmountSpices);
    }
}
