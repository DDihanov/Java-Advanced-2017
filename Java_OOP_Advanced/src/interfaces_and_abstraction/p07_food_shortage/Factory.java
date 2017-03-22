package interfaces_and_abstraction.p05_border_control;

import interfaces_and_abstraction.p05_border_control.interfaces.CitizenInterface;
import interfaces_and_abstraction.p05_border_control.models.Citizen;
import interfaces_and_abstraction.p05_border_control.models.Robot;

public class Factory {

    public CitizenInterface createCitizen(String... info){
        if(info.length == 2){
            CitizenInterface robot = new Robot(info[1], info[0]);

            return robot;
        }else if(info.length == 3){
            CitizenInterface citizen = new Citizen(info[2], info[0], Integer.parseInt(info[1]));

            return citizen;
        }

        return null;
    }
}
