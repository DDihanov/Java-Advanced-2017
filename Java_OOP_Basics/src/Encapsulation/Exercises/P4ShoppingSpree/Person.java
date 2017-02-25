package Encapsulation.Exercises.P4ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int money;
    private List<Product> products;

    public Person(String name, int money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        if(!canAfford(product)){
            System.out.println((String.format("%s can't afford %s", this.getName(), product.getName())));
            return;
        }
        System.out.printf("%s bought %s\n", this.getName(), product.getName());
        this.products.add(product);
        this.money -= product.getCost();
    }

    private boolean canAfford(Product product){
        return this.getMoney() >= product.getCost();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        if(name.isEmpty()||name.trim().length()==0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(int money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }


    @Override
    public String toString() {
        if(this.products.isEmpty()){
            return this.getName() + " - Nothing bought";
        }else{
            return String.format("%s - %s", this.getName(),
                    this.products.size() != 0 ?
                    this.getProducts()
                            .stream()
                            .map(c->c.toString())
                            .collect(Collectors.joining(", "))
                    : "Nothing bought");
        }
    }
}
