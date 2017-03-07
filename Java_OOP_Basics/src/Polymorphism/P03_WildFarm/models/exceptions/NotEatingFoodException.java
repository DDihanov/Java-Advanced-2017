package Polymorphism.P03_WildFarm.models.exceptions;

public class NotEatingFoodException extends IllegalArgumentException {
    public NotEatingFoodException(String s) {
        super(s);
    }
}
