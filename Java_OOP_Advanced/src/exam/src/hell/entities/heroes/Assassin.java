package hell.entities.heroes;

import hell.utils.Constants;

/**
 * Created by Austin on 23/04/2017.
 */
public class Assassin extends BaseHero {
    public Assassin(String name) {
        super(name, Constants.ASSASSIN_STRENGTH,
                Constants.ASSASSIN_AGILITY,
                Constants.ASSASSIN_INTELLIGENCE,
                Constants.ASSASSIN_HIT_POINTS,
                Constants.ASSASSIN_DAMAGE);
    }
}
