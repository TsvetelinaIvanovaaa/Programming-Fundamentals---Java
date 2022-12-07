package AssociativeArrays.Exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> coursesMap = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] studentsData = input.split("\\s+:");
            String courseName = studentsData[0];
            String registeredStudents = studentsData[1];

            if(!coursesMap.containsKey(courseName)){
                coursesMap.put(courseName, new ArrayList<>());
            }
            //studentGrade.get(name).add(grade);
            coursesMap.get(courseName).add(registeredStudents);

            input = scanner.nextLine();
        }

        //courseName -> List<String>
        coursesMap.entrySet()
                .forEach(entry -> {
                    //key: име на курса
                    //value: списък с хората
                    //име на курса -> бр. хората
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    entry.getValue().forEach(studentName -> System.out.println("--" + studentName));
                    //ascending order / нарастващ ред
                });

    }
}
