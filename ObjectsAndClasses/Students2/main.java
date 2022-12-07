package ObjectsAndClassesExercise.Students2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            String[] studentData = inputLine.split(" ");
            String firstName = studentData[0];
            String lastName = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String hometown = studentData[3];

            Student student = new Student(firstName, lastName, age, hometown);
            studentList.add(student);

            inputLine = scanner.nextLine();

        }
        String city = scanner.nextLine();
        for (Student student : studentList) {
            if(student.getHometown().equals(city)){
                System.out.printf("%s %s is %d years old%n",student.getFirstName(),student.getLastName(),student.getAge());
            }
        }
    }
}
