package interfaces_and_abstraction.p06_birthday_celebrations.models;

import interfaces_and_abstraction.p06_birthday_celebrations.interfaces.Birthdatable;

public class Citizen extends BaseCitizen implements Birthdatable {
    private int age;
    private String birthdate;

    public Citizen(String id, String name, int age,  String birthdate) {
        super(id, name);
        this.birthdate = birthdate;
        this.age = age;
    }

    @Override
    public String getBirthday() {
        return this.birthdate;
    }
}
