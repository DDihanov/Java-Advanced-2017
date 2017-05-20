package hell.commands;

import hell.annotations.Inject;
import hell.data.HeroDatabase;
import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;

/**
 * Created by Austin on 23/04/2017.
 */
public class HeroCommand implements Executable {
    @Inject
    private HeroDatabase heroDatabase;

    public HeroCommand() {
    }

    @Override
    public String execute(String... args) {
        Hero hero = null;
        String type = args[2];
        String name = args[1];
        switch(type){
            case"Barbarian":
                hero = new Barbarian(name);
                break;
            case"Assassin":
                hero = new Assassin(name);
                break;
            case"Wizard":
                hero = new Wizard(name);
                break;
        }

        this.heroDatabase.addHero(hero);
        return String.format("Created %s - %s", hero.getClass().getSimpleName(), hero.getName());
    }
}
