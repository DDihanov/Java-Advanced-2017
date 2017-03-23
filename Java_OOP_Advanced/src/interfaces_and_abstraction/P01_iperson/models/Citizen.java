package interfaces_and_abstraction.P01_iperson.models;

import interfaces_and_abstraction.P01_iperson.interfaces.Birthable;
import interfaces_and_abstraction.P01_iperson.interfaces.Identifiable;
import interfaces_and_abstraction.P01_iperson.interfaces.Person;

public class Citizen implements Person, Birthable, Identifiable {
    private String birthdate;
    private String id;
    private String name;
    private int age;

    public Citizen(String name, int age, String id, String birthdate) {
        this.id = id;
        this.birthdate = birthdate;
        this.name = name;
        this.age = age;
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
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
