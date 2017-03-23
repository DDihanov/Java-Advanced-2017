package interfaces_and_abstraction.p06_birthday_celebrations.models;

import interfaces_and_abstraction.p06_birthday_celebrations.interfaces.Birthdatable;

public class Pet implements Birthdatable {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthday() {
        return this.birthdate;
    }
}
