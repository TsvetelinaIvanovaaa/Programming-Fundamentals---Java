package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Shards -> количество
        //Fragments -> количество
        //Motes -> количество

        //запис: материал -> количество
        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("shards",0);
        items.put("fragments",0);
        items.put("motes",0);

        //запис: боклук -> количество
        Map<String, Integer> junkItems = new LinkedHashMap<>();

        boolean isWin = false;
        while(!isWin){
            String input = scanner.nextLine();
            String [] inputData = input.split(" ");
            for (int i = 0; i <= inputData.length-1 ; i+=2) {
                int quantity = Integer.parseInt(inputData[i]);
                String material = inputData[i+1].toLowerCase(); //всички букви да са малки

                if(material.equals("shards") || material.equals("fragments") || material.equals("motes")){
                    //имаме валиден материал;
                    int currentQuantity = items.get(material);
                    //взимам текущото количество на моя материал, от речника items ми
                    //вземи акква е стойността срещу съответния материал
                    items.put(material, currentQuantity + quantity);
                    //в моя речник искам да ми сложиш срещу моят материал да стои нова стойност, която е
                    //текущото количество + ново количество
                }else{
                    //материала е буклук
                    if(!junkItems.containsKey(material)){
                        //взимам другия речник и ако в него нямам такъв материал
                        junkItems.put(material, quantity);
                        //го добавям с неговото количество
                    }else{
                        //в противен случай, ако материала е добавен
                        //взимам текущата стойност на този материал
                        int current = junkItems.get(material);
                        //слагам нов запис, в коийто срещу този материал ми стои текущото количество + доп. количество
                        junkItems.put(material,current + quantity);
                    }
                }
                //проверка дали не сме спечелили магически айтем след получаване на всеки един материал
                if(items.get("shards") >= 250){
                    System.out.println("Shadowmourne obtained!");
                    items.put("shards",items.get("shards") - 250);
                    isWin = true;
                    break;

                }else if(items.get("fragments") >= 250){
                    System.out.println("Valanyr obtained!");
                    items.put("fragments",items.get("fragments") - 250);
                    isWin = true;
                    break;
                }else if(items.get("motes") >= 250){
                    System.out.println("Dragonwrath obtained!");
                    items.put("motes",items.get("motes") - 250);
                    isWin = true;
                    break;
                }
            }
            if(isWin){
                break;
            }
        }
        //отпечатваме всички специални материали
        //запис: материал -> количество
        items.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        //отпечатваме всички боклуци материали
        junkItems.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
