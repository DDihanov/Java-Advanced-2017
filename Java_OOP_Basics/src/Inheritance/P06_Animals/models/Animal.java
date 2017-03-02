package Inheritance.P06_Animals.models;

import Inheritance.P06_Animals.interfaces.SoundProducable;

public class Animal implements SoundProducable {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    protected void setGender(String gender) {
        if (gender.isEmpty() || gender.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        if(!gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append(this.getName())
                .append(" ")
                .append(this.getAge())
                .append(" ")
                .append(this.getGender())
                .append(System.lineSeparator())
                .append(this.produceSound())
                .append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }
}
