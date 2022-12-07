package ObjectsAndClassesExercise.opinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine()); // броят на редовете с лична информация

        for (int i = 1; i <= n ; i++) {
            String data = scanner.nextLine();
            String name = data.split(" ")[0];
            int age = Integer.parseInt(data.split(" ")[1]);

            if(age > 30){
                //създавам запис за човека и съхранявам този запис
                Person person = new Person(name, age);
                personList.add(person);
            }
        }
        for (Person person : personList) {
            //name - age
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
