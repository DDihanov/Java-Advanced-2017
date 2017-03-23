package interfaces_and_abstraction.p07_food_shortage.models;

import interfaces_and_abstraction.p07_food_shortage.interfaces.Buyer;

import java.util.HashMap;

public abstract class BuyerImpl extends BaseCitizen implements Buyer{
    private int food;
    private static final HashMap<String, Integer> FOOD_MODIFIERS;

    static {
        FOOD_MODIFIERS = new HashMap();
        FOOD_MODIFIERS.put("Rebel", 5);
        FOOD_MODIFIERS.put("Citizen", 10);
    }

    protected BuyerImpl(int age, String name) {
        super(age, name);
        this.food = 0;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void buyFood() {
        String type = this.getClass().getSimpleName();

        this.food += FOOD_MODIFIERS.get(type);
    }
}
