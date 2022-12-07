package FundamentalsFinalExamPreparation;

import java.util.*;

public class NeedForSpeedIIIOK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int countCars = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carsCollection = new LinkedHashMap<>();
        for (int i = 1; i <= countCars; i++) {
            String inputLine = scanner.nextLine();
            String[] carsData = inputLine.split("\\|");

            String car = carsData[0];
            int mileage = Integer.parseInt(carsData[1]);
            int fuel = Integer.parseInt(carsData[2]);

            if (!carsCollection.containsKey(car)) {
                carsCollection.put(car, new ArrayList<>());
                carsCollection.get(car).add(0, mileage);
                carsCollection.get(car).add(1, fuel);
            }
        }

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Stop")) {
            String[] commandsData = commandLine.split("\\s+:\\s+");
            String commandType = commandsData[0];

            if (commandType.contains("Drive")) {
                String car = commandsData[1];
                int distance = Integer.parseInt(commandsData[2]);
                int neededFuel = Integer.parseInt(commandsData[3]);

                if (carsCollection.get(car).get(1) >= neededFuel) {
                    int currentDistance = carsCollection.get(car).get(0);
                    currentDistance += distance;
                    carsCollection.get(car).remove(0);
                    carsCollection.get(car).add(0, currentDistance);
                    int currentFuel = carsCollection.get(car).get(1);
                    currentFuel -= neededFuel;
                    carsCollection.get(car).remove(1);
                    carsCollection.get(car).add(1, currentFuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, neededFuel);
                    if (carsCollection.get(car).get(0) >= 100000) {
                        carsCollection.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }

                } else {
                    System.out.println("Not enough fuel to make that ride");
                }
            } else if (commandType.contains("Refuel")) {
                String car = commandsData[1];
                int fuel = Integer.parseInt(commandsData[2]);
                int currentFuel = carsCollection.get(car).get(1);
                if (currentFuel + fuel <= 75) {
                    currentFuel += fuel;
                    carsCollection.get(car).remove(1);
                    carsCollection.get(car).add(1, currentFuel);
                    System.out.printf("%s refueled with %d liters%n", car, fuel);
                } else {
                    fuel = 75 - currentFuel;
                    currentFuel += fuel;
                    carsCollection.get(car).remove(1);
                    carsCollection.get(car).add(1, currentFuel);
                    System.out.printf("%s refueled with %d liters%n", car, fuel);
                }
            } else if (commandType.contains("Revert")) {
                String car = commandsData[1];
                int kilometers = Integer.parseInt(commandsData[2]);
                int currentMileage = carsCollection.get(car).get(0);
                currentMileage -= kilometers;
                if(currentMileage <= 10000){
                    currentMileage = 10000;
                    carsCollection.get(car).remove(0);
                    carsCollection.get(car).add(0,currentMileage);
                }else{
                    carsCollection.get(car).remove(0);
                    carsCollection.get(car).add(0,currentMileage);
                    System.out.printf("%s mileage decreased by %d kilometers%n",car, kilometers);
                }
            }
            commandLine = scanner.nextLine();
        }
        for (Map.Entry<String, List<Integer>> entry : carsCollection.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
