package FundamentalsMidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        int countMoves = 0;
        while (!command.equals("end")) {

            int firstIndex = Integer.parseInt(command.split(" ")[0]);
            int secondIndex = Integer.parseInt(command.split(" ")[1]);
            countMoves++;

            if (firstIndex == secondIndex || !(firstIndex >= 0 && firstIndex < sequence.size()) ||
                    !(secondIndex >= 0 && secondIndex < sequence.size())) {
                if (sequence.size() % 2 == 0) {
                    int indexFirstMiddleCharacter = sequence.size() / 2;
                    int indexSecondMiddleCharacter = sequence.size() / 2 - 1;

                    String newElement = "-" + countMoves + "a";
                    sequence.add(indexFirstMiddleCharacter, newElement);
                    sequence.add(indexSecondMiddleCharacter + 1, newElement);
                    System.out.println("Invalid input! Adding additional elements to the board");

                }
            } else {
                String firstElement = sequence.get(firstIndex);
                String secondElement = sequence.get(secondIndex);

                if (firstElement.equals(secondElement)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", firstElement);
                    if(firstIndex > secondIndex){
                        sequence.remove(firstIndex);
                        sequence.remove(secondIndex);
                    }else{
                        sequence.remove(secondIndex);
                        sequence.remove(firstIndex);
                    }


                } else {
                    System.out.println("Try again!");
                }
            }
            if (sequence.size() == 0) {
                System.out.printf("You have won in %d turns!%n", countMoves);
                break;
            }


            command = scanner.nextLine();
        }
        if (sequence.size() != 0) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", sequence));
            }
        }
    }

