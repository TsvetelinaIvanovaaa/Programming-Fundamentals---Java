package List.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        List<Integer> trainList = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")){
            if(command.contains("Add")){
                int passengers = Integer.parseInt(command.split(" ")[1]);
                trainList.add(passengers);
            }else{
                int morePassengers = Integer.parseInt(command.split(" ")[0]);
                for (int i = 0; i < trainList.size(); i++) {
                    int currentWagon = trainList.get(i);
                    int allPassenger = currentWagon + morePassengers;
                    if(allPassenger <= maxCapacity){
                        trainList.set(i,allPassenger);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int passengers : trainList) {
            System.out.print(passengers + " ");
        }
    }
}
