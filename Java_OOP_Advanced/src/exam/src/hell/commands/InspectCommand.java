package hell.commands;

import hell.annotations.Inject;
import hell.data.HeroDatabase;
import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.util.Collection;

/**
 * Created by Austin on 23/04/2017.
 */
public class InspectCommand implements Executable {
    @Inject
    private HeroDatabase heroDatabase;

    public InspectCommand() {
    }

    @Override
    public String execute(String... args) {
        StringBuilder sb = new StringBuilder();
        Hero hero = this.heroDatabase.getHero(args[1]);
        sb.append("Hero: ").append(hero.toString())
                .append(System.lineSeparator())
                .append("Items: ")
                .append(hero.getItems().isEmpty() ? "None" : this.getItemInfo(hero));
        return sb.toString();
    }

    private String getItemInfo(Hero hero) {
        StringBuilder sb = new StringBuilder();
        Collection<Item> itemList = hero.getItems();

        sb.append(System.lineSeparator());

        for (Item item : itemList) {
            sb.append(item.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
