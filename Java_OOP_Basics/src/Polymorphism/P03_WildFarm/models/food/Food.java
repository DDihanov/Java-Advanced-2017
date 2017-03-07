package Polymorphism.P03_WildFarm.models.food;

public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        this.setQuantity(quantity);
    }

    public Integer getQuantity() {
        return quantity;
    }

    private void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }
}
