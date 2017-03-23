package interfaces_and_abstraction.p07_food_shortage.models;

public class Rebel extends BuyerImpl{
    private String group;

    public Rebel(int age, String name, String group) {
        super(age, name);
        this.group = group;
    }


}
