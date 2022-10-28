package List.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while(!command.equals("End")){
            if(command.contains("Add")){
                int numberToAdd = Integer.parseInt(command.split("\\s+")[1]);
                numbersList.add(numberToAdd);
            }else if(command.contains("Insert")){
                int numberToInsert = Integer.parseInt(command.split("\\s+")[1]);
                int index = Integer.parseInt(command.split("\\s+")[2]);
                if(isValidIndex(numbersList, index)){
                    numbersList.add(index, numberToInsert);
                }else{
                    System.out.println("Invalid index");
                }
            }else if(command.contains("Remove")){
                int removeIndex = Integer.parseInt(command.split("\\s+")[1]);
                if(isValidIndex(numbersList, removeIndex)){
                    numbersList.remove(removeIndex);
                }else{
                    System.out.println("Invalid index");
                }

            }else if(command.contains("Shift left")){
                int countTimes = Integer.parseInt(command.split("\\s+")[2]);
                for (int i = 1; i <=countTimes ; i++) {
                    int firstNumber = numbersList.get(0);
                    numbersList.remove(0);
                    numbersList.add(firstNumber);
                }
            }else if(command.contains("Shift right")){
                int countTimes = Integer.parseInt(command.split("\\s+")[2]);
                for (int i = 1; i <= countTimes ; i++) {
                    int lastNumber = numbersList.get(numbersList.size()-1);
                    numbersList.remove(numbersList.size()-1);
                    numbersList.add(0, lastNumber);
                }
            }
            command = scanner.nextLine();
        }
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
    }
    public static boolean isValidIndex (List<Integer> numbers,int index){
        return (index >= 0 && index <= numbers.size()-1);
        }
    }

