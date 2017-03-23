package interfaces_and_abstraction.p10_mood_3;

import interfaces_and_abstraction.p10_mood_3.interfaces.IGameObject;
import interfaces_and_abstraction.p10_mood_3.models.Archangel;
import interfaces_and_abstraction.p10_mood_3.models.Demon;

public class GameObjectFactory {

    public IGameObject createGameObject(String... args){
        switch(args[1]){
            case"Demon":
                return new Demon(args[0], Integer.parseInt(args[3]), Double.parseDouble(args[2]));
            case"Archangel":
                return new Archangel(args[0], Integer.parseInt(args[3]), Integer.parseInt(args[2]));
            default:
                return null;
        }
    }
}
