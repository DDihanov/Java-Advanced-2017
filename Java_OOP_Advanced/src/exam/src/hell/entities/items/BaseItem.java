package hell.entities.items;

import hell.interfaces.Item;

/**
 * Created by Austin on 23/04/2017.
 */
public abstract class BaseItem implements Item {
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointBonus;
    private int damageBonus;

    protected BaseItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointBonus = hitPointBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("###Item: ").append(this.getName())
                .append(System.lineSeparator())
                .append("###+").append(this.getStrengthBonus()).append(" Strength")
                .append(System.lineSeparator())
                .append("###+").append(this.getAgilityBonus()).append(" Agility")
                .append(System.lineSeparator())
                .append("###+").append(this.getIntelligenceBonus()).append(" Intelligence")
                .append(System.lineSeparator())
                .append("###+").append(this.getHitPointsBonus()).append(" HitPoints")
                .append(System.lineSeparator())
                .append("###+").append(this.getDamageBonus()).append(" Damage");

        return sb.toString();
    }
}
