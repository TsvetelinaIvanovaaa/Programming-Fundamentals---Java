package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().replaceAll("\\s+","");
        //replace - в текста ми замени всяко срещане на интервал с никакъв стринг
        //символ -> бр. срещания
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();
        //Hashmap -> няма значение редът на записите
        //LinkedHashMap -> записите се подреждат се спрямо редът на добавяне
        //TreeMap -> записите се сортират спямо техния ключ

        for (char symbol : text.toCharArray()) {
            //1.да не съм срещала такъв символ
 //           if(symbol == ' '){
 //               continue; //пропуска всичко на долу и минава към следващият символ
 //           }
            if(!symbolsCount.containsKey(symbol)){
                symbolsCount.put(symbol,1);
            }
            //2.да съм срещата сумвола
            else{
                int currentCount = symbolsCount.get(symbol); //текущия брой на срещанията
                symbolsCount.put(symbol,currentCount + 1);
            }
        }
        //отпечатваме
        //символ -> брой на срещанията
        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
