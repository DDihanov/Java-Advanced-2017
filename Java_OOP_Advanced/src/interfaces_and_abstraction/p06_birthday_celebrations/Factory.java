package interfaces_and_abstraction.p06_birthday_celebrations;


import interfaces_and_abstraction.p06_birthday_celebrations.interfaces.Birthdatable;
import interfaces_and_abstraction.p06_birthday_celebrations.models.Citizen;
import interfaces_and_abstraction.p06_birthday_celebrations.models.Pet;

public class Factory {

    public Birthdatable createUnit(String... info){
        switch(info[0]){
            case"Citizen":
                return new Citizen(info[3], info[1], Integer.parseInt(info[2]), info[4]);
            case"Pet":
                return new Pet(info[1], info[2]);
            default:
                return null;
        }
    }
}
