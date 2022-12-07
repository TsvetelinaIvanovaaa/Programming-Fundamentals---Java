package ObjectsAndClassesExercise.opinionPoll;

public class Person {
    //полета -> характеристики - име и възраст
    private String name;
    private int age;

    //конструктор -> създаваме обекти от класа
    public Person (String name, int age){
        //нов обект
        this.name = name;
        this.age = age;
    }
    //методи -> описваме поведение(какво може да прави всеки един обект)
    //ако е необходимо

    //getter -> метод, чрез който достъпваме стойност от поле
    public String getName(){
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
}
