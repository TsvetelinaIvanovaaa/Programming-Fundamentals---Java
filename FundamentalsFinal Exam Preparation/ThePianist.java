package FundamentalsFinalExamPreparation;

import java.util.*;

public class ThePianistOK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> collectionsPiece = new LinkedHashMap<>();

        int piecesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= piecesCount; i++) {
            String inputLine = scanner.nextLine();
            String[] piecesData = inputLine.split("\\|");
            String piece = piecesData[0];
            String composer = piecesData[1];
            String key = piecesData[2];

            if (!collectionsPiece.containsKey(piece)) {
                collectionsPiece.put(piece, new ArrayList<>());
                collectionsPiece.get(piece).add(composer);
                collectionsPiece.get(piece).add(key);
            }
        }
        String commandInput = scanner.nextLine();
        while (!commandInput.equals("Stop")) {
            String[] commandData = commandInput.split("\\|");
            String commandType = commandData[0];

            if (commandType.contains("Add")) {
                String piece = commandData[1];
                String composer = commandData[2];
                String key = commandData[3];

                if (!collectionsPiece.containsKey(piece)) {
                    collectionsPiece.put(piece,new ArrayList<>());
                    collectionsPiece.get(piece).add(composer);
                    collectionsPiece.get(piece).add(key);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                } else {
                    System.out.printf("%s is already in the collection!%n", piece);
                }
            } else if (commandType.contains("Remove")) {
                String piece = commandData[1];

                if (collectionsPiece.containsKey(piece)) {
                    collectionsPiece.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            } else if (commandType.contains("ChangeKey")) {
                String piece = commandData[1];
                String newKey = commandData[2];

                if (collectionsPiece.containsKey(piece)) {
                    collectionsPiece.get(piece).add(1,newKey);
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                }else{
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                }
            }
            commandInput =scanner.nextLine();
        }
        //collectionsPiece.entrySet().stream()
               //.forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                       //kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));
        for (Map.Entry<String, List<String>> entry : collectionsPiece.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n",
                    entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
