package hell.commands;

import hell.annotations.Inject;
import hell.data.HeroDatabase;
import hell.entities.items.CommonItem;
import hell.interfaces.Item;

/**
 * Created by Austin on 23/04/2017.
 */
public class ItemCommand implements Executable {
    @Inject
    private HeroDatabase heroDatabase;

    @Override
    public String execute(String... args) {
        int str = Integer.parseInt(args[3]);
        int agil = Integer.parseInt(args[4]);
        int intel = Integer.parseInt(args[5]);
        int hp = Integer.parseInt(args[6]);
        int dmg = Integer.parseInt(args[7]);


        Item item = new CommonItem(args[1], str, agil, intel, hp, dmg);
        this.heroDatabase.getHero(args[2]).addItem(item);

        return String.format("Added item - %s to Hero - %s", args[1], args[2]);
    }
}
