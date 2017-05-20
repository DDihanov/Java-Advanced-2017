package hell.commands;

import hell.annotations.Inject;
import hell.data.HeroDatabase;
import hell.entities.items.RecipeImpl;
import hell.interfaces.Recipe;

/**
 * Created by Austin on 23/04/2017.
 */
public class RecipeCommand implements Executable {
    @Inject
    private HeroDatabase heroDatabase;

    @Override
    public String execute(String... args) {
        Recipe item;
        int str = Integer.parseInt(args[3]);
        int agil = Integer.parseInt(args[4]);
        int intel = Integer.parseInt(args[5]);
        int hp = Integer.parseInt(args[6]);
        int dmg = Integer.parseInt(args[7]);
        String[] requiredItems;

        if(args.length >= 8){
            requiredItems = new String[args.length - 8];
            int itemCounter = 0;
            for (int i = 8; i < args.length; i++) {
                requiredItems[itemCounter] = args[i];
                itemCounter++;
            }

            item = new RecipeImpl(args[1], str, agil, intel, hp, dmg, requiredItems);
        }else{
            item = new RecipeImpl(args[1], str, agil, intel, hp, dmg);
        }


        this.heroDatabase.getHero(args[2]).addRecipe(item);

        return String.format("Added recipe - %s to Hero - %s", args[1], args[2]);
    }
}
