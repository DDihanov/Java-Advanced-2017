package interfaces_and_abstraction.p07_food_shortage;

import interfaces_and_abstraction.p07_food_shortage.interfaces.Buyer;
import interfaces_and_abstraction.p07_food_shortage.models.Citizen;
import interfaces_and_abstraction.p07_food_shortage.models.Rebel;

public class Factory {

    public Buyer createCitizen(String... info){
        if(info.length == 3){
            Buyer rebel = new Rebel(Integer.parseInt(info[1]), info[0], info[2]);

            return rebel;
        }else if(info.length == 4){
            Buyer citizen = new Citizen(info[2], info[0], Integer.parseInt(info[1]),info[3]);
            return citizen;
        }

        return null;
    }
}
