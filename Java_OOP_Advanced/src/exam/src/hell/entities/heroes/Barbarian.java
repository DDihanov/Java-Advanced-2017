package hell.entities.heroes;

import hell.utils.Constants;

/**
 * Created by Austin on 23/04/2017.
 */
public class Barbarian extends BaseHero {
    public Barbarian(String name) {
        super(name, Constants.BARBARIAN_STRENGTH,
                Constants.BARBARIAN_AGILITY,
                Constants.BARBARIAN_INTELLIGENCE,
                Constants.BARBARIAN_HIT_POINTS,
                Constants.BARBARIAN_DAMAGE);
    }
}
