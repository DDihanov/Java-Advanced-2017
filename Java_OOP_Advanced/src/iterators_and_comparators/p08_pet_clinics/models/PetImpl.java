package iterators_and_comparators.p08_pet_clinics.models;

import iterators_and_comparators.p08_pet_clinics.interfaces.Pet;

public class PetImpl implements Pet {
    private int age;
    private String name;
    private String kind;

    public PetImpl(int age, String name, String kind) {
        this.age = age;
        this.setName(name);
        this.kind = kind;
    }

    private void setName(String name) {
        if(name.trim().length() == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
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
    public String getKind() {
        return this.kind;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.getName(), this.getAge(), this.getKind());
    }
}
