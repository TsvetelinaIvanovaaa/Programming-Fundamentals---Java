package FundamentalsFinalExamPreparation;

import java.util.*;

public class PiratesOK {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<String, Integer> cityPopulationMap = new LinkedHashMap<>();
        Map<String, Integer> cityGoldMap = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();
        while(!inputLine.equals("Sail")){
            String[] tokens = inputLine.split("\\|+");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if(!cityPopulationMap.containsKey(city)){
                cityPopulationMap.put(city, population);
                cityGoldMap.put(city, gold);
            }else{
                int currentPopulation = cityPopulationMap.get(city);
                int currentGold = cityGoldMap.get(city);

                cityPopulationMap.put(city, currentPopulation + population);
                cityGoldMap.put(city, currentGold + gold);
            }
            inputLine = scanner.nextLine();
        }
        String events = scanner.nextLine();
        while (!events.equals("End")){
            String[] tokens = events.split("=>");
            String command = tokens[0];

            if(command.equals("Plunder")){
                String city = tokens[1];
                int population = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);

                int currentPopulation = cityPopulationMap.get(city);
                int currentGold = cityGoldMap.get(city);
                currentPopulation -= population;
                currentGold -= gold;
                cityPopulationMap.put(city, currentPopulation);
                cityGoldMap.put(city, currentGold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",city, gold, population);
                if(currentPopulation <= 0 || currentGold <= 0){
                    cityPopulationMap.remove(city);
                    cityGoldMap.remove(city);
                    System.out.printf("%s has been wiped off the map!%n", city);
                }
            }else if(command.equals("Prosper")){
                String city = tokens[1];
                int gold = Integer.parseInt(tokens[2]);

                if(gold >= 0){
                    int currentGold = cityGoldMap.get(city);
                    currentGold += gold;
                    cityGoldMap.put(city, currentGold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",gold,
                            city, currentGold);
                }else{
                    System.out.println("Gold added cannot be a negative number!");
                }
            }
            events = scanner.nextLine();
        }
        if(!cityPopulationMap.isEmpty()){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cityPopulationMap.size());
            for (Map.Entry<String, Integer> entry : cityPopulationMap.entrySet()) {
                String currentCity = entry.getKey();
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",entry.getKey(), entry.getValue(),
                        cityGoldMap.get(currentCity));
            }
        }else{
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
