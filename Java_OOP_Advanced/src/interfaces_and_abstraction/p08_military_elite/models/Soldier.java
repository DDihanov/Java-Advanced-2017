package interfaces_and_abstraction.p08_military_elite.models;

import interfaces_and_abstraction.p08_military_elite.interfaces.ISoldier;

public abstract class Soldier implements ISoldier{
    private int id;
    private String firstName;
    private String lastName;

    protected Soldier(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d ",
                this.getFirstName(),
                this.getLastName(),
                this.getId());
    }
}
