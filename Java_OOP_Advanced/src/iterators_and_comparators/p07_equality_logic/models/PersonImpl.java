package iterators_and_comparators.p07_equality_logic.models;

import iterators_and_comparators.p07_equality_logic.interfaces.Person;

public class PersonImpl implements Person, Comparable<PersonImpl> {
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

    @Override
    public int hashCode() {
        return this.getName().hashCode() * this.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int compareTo(PersonImpl person) {
        if (this.getName().compareTo(person.getName()) == 0) {
            return this.getAge() - person.getAge();
        }
        return this.getName().compareTo(person.getName());
    }
}
