package hell.entities.heroes;

import hell.utils.Constants;

/**
 * Created by Austin on 23/04/2017.
 */
public class Wizard extends BaseHero {
    public Wizard(String name) {
        super(name,
                Constants.WIZARD_STRENGTH,
                Constants.WIZARD_AGILITY,
                Constants.WIZARD_INTELLIGENCE,
                Constants.WIZARD_HIT_POINTS,
                Constants.WIZARD_DAMAGE);
    }
}
