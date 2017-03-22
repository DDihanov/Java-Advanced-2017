package interfaces_and_abstraction.p05_border_control.models;

import interfaces_and_abstraction.p05_border_control.interfaces.CitizenInterface;

public class BaseCitizen implements CitizenInterface {
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
