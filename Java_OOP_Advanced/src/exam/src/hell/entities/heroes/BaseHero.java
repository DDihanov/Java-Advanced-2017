package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import hell.utils.Constants;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Austin on 23/04/2017.
 */
public abstract class BaseHero implements Hero{
    private static final String CONSTANTS_DIRECTORY = "hell.utils.Constants";
    private static final String HP_SUFFIX = "_HIT_POINTS";
    private static final String STRENGTH_SUFFIX = "_STRENGTH";
    private static final String AGILITY_SUFFIX = "_AGILITY";
    private static final String INTELLIGENCE_SUFFIX = "_INTELLIGENCE";
    private static final String DAMAGE_SUFFIX = "_DAMAGE";

    private static final Map<String, Map<String, Integer>> HEROES_BASE_STATS;

    static{
        HEROES_BASE_STATS = new HashMap<>();
        HEROES_BASE_STATS.put("Wizard",new HashMap<>());
        HEROES_BASE_STATS.get("Wizard").put("HP", Constants.WIZARD_HIT_POINTS);
        HEROES_BASE_STATS.get("Wizard").put("DAMAGE", Constants.WIZARD_DAMAGE);
        HEROES_BASE_STATS.get("Wizard").put("INT", Constants.WIZARD_INTELLIGENCE);
        HEROES_BASE_STATS.get("Wizard").put("STR", Constants.WIZARD_STRENGTH);
        HEROES_BASE_STATS.get("Wizard").put("AGL", Constants.WIZARD_AGILITY);


        HEROES_BASE_STATS.put("Barbarian",new HashMap<>());
        HEROES_BASE_STATS.get("Barbarian").put("HP", Constants.BARBARIAN_HIT_POINTS);
        HEROES_BASE_STATS.get("Barbarian").put("DAMAGE", Constants.BARBARIAN_DAMAGE);
        HEROES_BASE_STATS.get("Barbarian").put("INT", Constants.BARBARIAN_INTELLIGENCE);
        HEROES_BASE_STATS.get("Barbarian").put("STR", Constants.BARBARIAN_STRENGTH);
        HEROES_BASE_STATS.get("Barbarian").put("AGL", Constants.BARBARIAN_AGILITY);

        HEROES_BASE_STATS.put("Assassin",new HashMap<>());
        HEROES_BASE_STATS.get("Assassin").put("HP", Constants.ASSASSIN_HIT_POINTS);
        HEROES_BASE_STATS.get("Assassin").put("DAMAGE", Constants.ASSASSIN_DAMAGE);
        HEROES_BASE_STATS.get("Assassin").put("INT", Constants.ASSASSIN_INTELLIGENCE);
        HEROES_BASE_STATS.get("Assassin").put("STR", Constants.ASSASSIN_STRENGTH);
        HEROES_BASE_STATS.get("Assassin").put("AGL", Constants.ASSASSIN_AGILITY);
    }

    private String name;
    private int strenght;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private HeroInventory heroInventory;

    protected BaseHero(String name, int strenght, int agility, int intelligence, int hitPoints, int damage) {
        this.setName(name);
        this.setStrenght(strenght);
        this.setAgility(agility);
        this.setIntelligence(intelligence);
        this.setHitPoints(hitPoints);
        this.setDamage(damage);
        this.heroInventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strenght;
    }

    @Override
    public long getAgility() {
        return this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.damage;
    }

    @Override
    public Collection<Item> getItems() {
        Class heroInventoryClass = this.heroInventory.getClass();
        Collection<Item> items = new ArrayList<>();
        Map<String, Item> itemMap = null;
        Field[] fields = heroInventoryClass.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(ItemCollection.class)){
                field.setAccessible(true);
                try {
                    itemMap = (Map<String, Item>) field.get(this.heroInventory);
                    items.addAll(itemMap.values());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return Collections.unmodifiableCollection(items);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    private void setAgility(int agility) {
        this.agility = agility;
    }

    private void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    private void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    private void setHeroInventory(HeroInventory heroInventory) {
        this.heroInventory = heroInventory;
    }

    @Override
    public void addItem(Item item) {
        this.heroInventory.addCommonItem(item);
        this.updateParameters();
    }

    private void updateParameters() {
        String heroType = this.getClass().getSimpleName();
        Collection<Item> items = this.getItems();
        int damage = HEROES_BASE_STATS.get(heroType).get("DAMAGE");
        int hp = HEROES_BASE_STATS.get(heroType).get("HP");
        int intelligence = HEROES_BASE_STATS.get(heroType).get("INT");
        int agility = HEROES_BASE_STATS.get(heroType).get("AGL");
        int strength = HEROES_BASE_STATS.get(heroType).get("STR");

        for (Item item1 : items) {
            hp+=item1.getHitPointsBonus();
            damage+=item1.getDamageBonus();
            intelligence+=item1.getIntelligenceBonus();
            agility+=item1.getAgilityBonus();
            strength+=item1.getStrengthBonus();
        }

        this.setDamage(damage);
        this.setHitPoints(hp);
        this.setIntelligence(intelligence);
        this.setAgility(agility);
        this.setStrenght(strength);
    }


//    private int modifyStats(Item item, String heroType) {
//        this.setDamageitem.getDamageBonus());
//        this.setHitPoints(HEROES_BASE_STATS.get(heroType).get("HP") + item.getHitPointsBonus());
//        this.setIntelligence(HEROES_BASE_STATS.get(heroType).get("INT") + item.getIntelligenceBonus());
//        this.setAgility(HEROES_BASE_STATS.get(heroType).get("AGL") + item.getAgilityBonus());
//        this.setStrenght(HEROES_BASE_STATS.get(heroType).get("STR") + item.getStrengthBonus());
//    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.heroInventory.addRecipeItem(recipe);
        this.updateParameters();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(", Class: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("HitPoints: ").append(this.getHitPoints()).append(", Damage: ").append(this.getDamage())
                .append(System.lineSeparator())
                .append("Strength: ").append(this.getStrength())
                .append(System.lineSeparator())
                .append("Agility: ").append(this.getAgility())
                .append(System.lineSeparator())
                .append("Intelligence: ").append(this.getIntelligence());

        return sb.toString();
    }


}
