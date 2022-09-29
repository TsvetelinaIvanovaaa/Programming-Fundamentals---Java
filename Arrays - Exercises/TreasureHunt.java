package Arrays.Exercise;

import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String enoughActions = "Yohoho!"; // enough input elements

        String input = scanner.nextLine(); // reading a first line with treasures
        String[] treasuresArray = input.split("\\|"); // converting a string to array of treasures

        String action = scanner.nextLine(); // reading next line with action/END

        while (!action.equals(enoughActions)) { // we have a valid action amongst Loot, Drop, Steal
            String[] actionString = action.split(" "); // converting an action to array so to be able to check the first element
            String currentAction = actionString[0]; // first element of the new array = taken action

            switch (currentAction) {
                case "Loot": // insert the items in the original array if they do not exist there
                    for (int i = 1; i < actionString.length; i++) {
                        String currentElement = actionString[i]; // take the element to insert
                        boolean currentElementExist = false; // flag to check if this element exists

                        for (int j = 0; j < treasuresArray.length; j++) { // loop to chek if the element exists in the original array
                            if (currentElement.equals(treasuresArray[j])) {
                                currentElementExist = true; // element exists, the loop will be terminated
                                break;
                            }
                        }

                        if (!currentElementExist) { // the element does not exist, it will be inserted
                            String[] tempArray = new String[treasuresArray.length + 1]; // new temporary array with one element longer than the original
                            tempArray[0] = currentElement; // the ney element is inserted on the first position

                            for (int j = 1; j < tempArray.length; j++) { // the other elements are copied from original array to a temp one
                                tempArray[j] = treasuresArray[j - 1];
                            }
                            treasuresArray = tempArray; // the original array now points to the temp one
                        }
                    }
                    break;
                case "Drop": // removes an element from concrete position and adds it to the end
                    int indexDrop = Integer.parseInt(actionString[1]); // position
                    if (0 <= indexDrop && indexDrop < treasuresArray.length) { // check if the position is valid
                        String[] tempArray = new String[treasuresArray.length]; // one temp array with the same length as original one
                        int j = 0; // new array indexes
                        for (int i = 0; i < treasuresArray.length; i++) { // all the elements from the original array except the one in the indexDrop position are copied to the temp array
                            if (i == indexDrop) {
                                tempArray[tempArray.length - 1] = treasuresArray[i]; // the element at the position indexDrop is copied to the end
                            } else {
                                tempArray[j++] = treasuresArray[i];
                            }
                        }
                        treasuresArray = tempArray; // the original array now points to the temp one
                    }
                    break;
                case "Steal": // removes the last countSteal elements and prints them, if the index is lower than the array length
                    int countSteal = Integer.parseInt(actionString[1]);
                    if (1 <= countSteal && countSteal < treasuresArray.length) { // check if the count elements is valid
                        String[] tempArray = new String[treasuresArray.length - countSteal]; // one temp array with countSteal elements less length
                        for (int i = 0; i < treasuresArray.length; i++) {
                            if (i < treasuresArray.length - countSteal) { // first few elements will be copied to temp array
                                tempArray[i] = treasuresArray[i];
                            } else  if (i < treasuresArray.length - 1){ // the removed elements will be printed except the last one
                                System.out.printf("%s, ", treasuresArray[i]);
                            }
                        }
                        System.out.println(treasuresArray[treasuresArray.length - 1]);
                        treasuresArray = tempArray; // the original array now points to the temp one
                    } else if (treasuresArray.length <= countSteal) { // removes all the elements of the array
                        for (int i = 0; i < treasuresArray.length - 1; i++) {
                            System.out.printf("%s, ", treasuresArray[i]);
                        }
                        System.out.println(treasuresArray[treasuresArray.length - 1]);
                        treasuresArray = null; // set the original array to empty one
                    } else { // negative count of elements
                        System.out.println("Wrong Number!");
                    }
                    break;
                default:
                    System.out.println("Wrong Action!");
                    break;

            }

            action = scanner.nextLine();
        }

        if (treasuresArray != null) {
            int sum = 0;
            for (int i = 0; i < treasuresArray.length; i++) {
                String currentElement = treasuresArray[i];
                sum += currentElement.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", 1.0 * sum / treasuresArray.length);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}