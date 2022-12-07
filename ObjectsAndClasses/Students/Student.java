package ObjectsAndClassesExercise.Students;

public class Student {
    //полета -> характеристики -> име, фамилия, оценки
    private String name;
    private String lastName;
    private double grade;

    //конструктор -> създаване на обекти от класа
    public Student(String name, String lastName, double grade){
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
    }
    //getter

    public double getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        //"{first name} {second name}: {grade}"
        return String.format("%s %s: %.2f",this.name, this.lastName, this.grade);
    }
}
