package ObjectsAndClassesExercise.VehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int hp;

    public Vehicle (String type, String model, String color, int hp){
        this.type = type;
        this.model = model;
        this.color = color;
        this.hp = hp;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public int getHp() {
        return this.hp;
    }

    @Override
    public String toString() {
        String formattedType = " ";
        if(this.type.equals("car")){
            formattedType = "Car";
        }else if(this.type.equals("truck")){
            formattedType = "Truck";
        }
        return "Type: " + formattedType + "\n" +
                "Model: " +  model + "\n" +
                "Color: " + color + "\n" +
                "Horsepower: " + hp;
    }
}
