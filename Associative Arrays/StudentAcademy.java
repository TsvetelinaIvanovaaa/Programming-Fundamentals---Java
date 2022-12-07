package AssociativeArrays.Exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //студент -> списък с оценките
        Map<String, List<Double>> studentGrade = new LinkedHashMap<>();

        int countStudent = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countStudent; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            //1. студента да го няма записан
            if (!studentGrade.containsKey(name)) {
                studentGrade.put(name, new ArrayList<>());
            }
            //2. студента да е записан
            studentGrade.get(name).add(grade);
        }
        //име на студента -> списък с неговите оценки
        //записи: име на студента(ключ) -> средна оценка(стойност)
        Map<String, Double> averageGradeStudents = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : studentGrade.entrySet()) {
            String studentName = entry.getKey(); //име на студента
            List<Double> ListGrades = entry.getValue(); //списък с оценките за всеки студент
            double averageGrade = getAverageGrade(ListGrades);
            if(averageGrade >= 4.50){
                averageGradeStudents.put(studentName, averageGrade);
            }
        }
        averageGradeStudents.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue()));
    }


    private static double getAverageGrade(List<Double> ListGrades) {
        double sumGrades = 0;
        for (double grade : ListGrades) {
            sumGrades += grade;
        }
        return sumGrades / ListGrades.size();
    }
}
