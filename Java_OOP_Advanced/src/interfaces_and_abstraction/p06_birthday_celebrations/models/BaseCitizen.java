package interfaces_and_abstraction.p06_birthday_celebrations.models;

import interfaces_and_abstraction.p06_birthday_celebrations.interfaces.Identifiable;

public class BaseCitizen implements Identifiable {
    private String id;
    private String name;

    protected BaseCitizen(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
