package interfaces_and_abstraction.p08_military_elite.models;

import interfaces_and_abstraction.p08_military_elite.interfaces.ISpecialisedSoldier;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier{
    private String corps;

    protected SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Corps: %s\n", this.getCorps());
    }

    @Override
    public void setCorps(String corps) {
        if(!corps.equals("Airforces") && !corps.equals("Marines")){
            throw new IllegalArgumentException(); //invalid corps
        }

        this.corps = corps;
    }
}
