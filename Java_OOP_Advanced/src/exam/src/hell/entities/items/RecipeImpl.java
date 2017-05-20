package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Austin on 23/04/2017.
 */
public class RecipeImpl extends BaseItem implements Recipe {
    private List<String> requiredItems;

    public RecipeImpl(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointBonus, int damageBonus, String... requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointBonus, damageBonus);
        this.requiredItems = Arrays.asList(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
    }
}
