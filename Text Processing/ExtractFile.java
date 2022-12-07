package TextProcessing.Exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine(); //C:\Internal\training-internal\Template.pptx
        String[] pathParts = path.split("\\\\");
        String fullFileName = pathParts[pathParts.length-1];

        String fileName = fullFileName.split("\\.")[0];
        String extension = fullFileName.split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}

//String path = scanner.nextLine();
//int indexLast = path.lastIndexOf("\\");
//String fullFileName = path.substring(indexLast + 1);

//int indexPoint = fullFileName.indexOf(".");
//String fileName = fullFileName.substring(0,indexPoint);
//String fileExtension = fullFileName.substring(indexPoint + 1);

//System.out.println("File name: " + fileName);
//System.out.println("File extension: " + extension);