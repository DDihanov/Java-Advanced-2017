package interfaces_and_abstraction.p07_food_shortage.models;

public abstract class BaseCitizen{
    private int age;
    private String name;

    protected BaseCitizen(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
