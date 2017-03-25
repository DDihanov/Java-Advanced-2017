package iterators_and_comparators.p06_strategy_pattern.models;

import iterators_and_comparators.p06_strategy_pattern.interfaces.Person;

public class PersonImpl implements Person {
    private int age;
    private String name;

    public PersonImpl(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getAge();
    }
}
