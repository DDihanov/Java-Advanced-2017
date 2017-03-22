package interfaces_and_abstraction.p05_border_control.models;

public class Citizen extends BaseCitizen {
    private int age;

    public Citizen(String id, String name, int age) {
        super(id, name);
        this.age = age;
    }
}
