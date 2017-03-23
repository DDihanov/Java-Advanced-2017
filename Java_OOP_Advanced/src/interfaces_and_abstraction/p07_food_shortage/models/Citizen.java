package interfaces_and_abstraction.p07_food_shortage.models;

public class Citizen extends BuyerImpl{
    private String id;
    private String birthdate;

    public Citizen(String id, String name, int age, String birthdate) {
        super(age , name);
        this.id = id;
        this.birthdate = birthdate;
    }
}
