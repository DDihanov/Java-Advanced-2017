package hell.data;

import hell.interfaces.Hero;

/**
 * Created by Austin on 23/04/2017.
 */
public interface HeroDatabase {
    void addHero(Hero hero);
    Hero getHero(String heroName);
}
