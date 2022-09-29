package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());//брой на кеговете
        //за всеки един кег олучаваме: модел, радиус и височина;

        double maxVolume = Double.MIN_VALUE;
        String maxModel = ""; //тук ще пазим модела на най-големия кег;
        for (int i = 1; i <= n ; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            //обем на кега = pi*r^2*h
            double volume = Math.PI * Math.pow(radius, 2) * height;

            //проверка дали е най-голям;
            if(volume > maxVolume){
                maxVolume = volume;
                maxModel = model;
            }
        }
        System.out.println(maxModel);
    }
}
