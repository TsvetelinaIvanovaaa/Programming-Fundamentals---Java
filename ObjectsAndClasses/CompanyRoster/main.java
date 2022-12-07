package ObjectsAndClassesExercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();
        int countEmployee = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countEmployee; i++) {
            String employeeData = scanner.nextLine();
            String[] employeeDataType = employeeData.split(" ");

            Employee newEmployee = new Employee(
                    employeeDataType[0],
                    Double.parseDouble(employeeDataType[1]),
                    employeeDataType[2],
                    employeeDataType[3]
            );
            if (employeeDataType.length > 4) {
                if (employeeDataType[4].contains("@")) {
                    newEmployee.setEmail(employeeDataType[4]);
                } else {
                    newEmployee.setAge(Integer.parseInt(employeeDataType[4]));
                }

                if (employeeDataType.length > 5) {
                    newEmployee.setAge(Integer.parseInt(employeeDataType[5]));
                }
            }
            employeeList.add(newEmployee);
            //String name = employeeDataType[0];
            //double salary = Double.parseDouble(employeeDataType[1]);
            //String position = employeeDataType[2];
            //String department = employeeDataType[3];


        }
    }
}
