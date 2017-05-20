package hell.data;

import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Austin on 23/04/2017.
 */
public class HeroDatabaseImpl implements HeroDatabase {
    private Map<String, Hero> heroes;

    public HeroDatabaseImpl() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public void addHero(Hero hero) {
        this.heroes.put(hero.getName(), hero);
    }

    @Override
    public Hero getHero(String heroName) {
        return this.heroes.get(heroName);
    }

    @Override
    public String toString() {
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        List<Map.Entry<String, Hero>> heroesSorted = heroes.entrySet().stream().sorted((h1, h2) -> {
            long sum1 = h1.getValue().getAgility() + h1.getValue().getStrength() + h1.getValue().getIntelligence();
            long sum2 = h2.getValue().getAgility() + h2.getValue().getStrength() + h2.getValue().getIntelligence();
            if (sum1 == sum2) {
                long sum3 = h2.getValue().getHitPoints() + h2.getValue().getDamage();
                long sum4 = h1.getValue().getHitPoints() + h1.getValue().getDamage();
                return Long.compare(sum3, sum4);
            }
            return Long.compare(sum2, sum1);
        }).collect(Collectors.toList());

        for (Map.Entry<String, Hero> hero : heroesSorted) {
            Collection<Item> items = hero.getValue().getItems();
            String heroItems = this.getHeroItems(hero.getValue().getItems());
            String heroInfo = this.appendHero(hero.getValue());
            sb.append(counter).append(". ").append(heroInfo).append(System.lineSeparator())
                    .append("###Items: ").append(heroItems).append(System.lineSeparator());
            counter++;
        }

        return sb.toString();
    }

    private String appendHero(Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append(hero.getClass().getSimpleName()).append(": ").append(hero.getName())
                .append(System.lineSeparator())
                .append("###HitPoints: ").append(hero.getHitPoints())
                .append(System.lineSeparator())
                .append("###Damage: ").append(hero.getDamage())
                .append(System.lineSeparator())
                .append("###Strength: ").append(hero.getStrength())
                .append(System.lineSeparator())
                .append("###Agility: ").append(hero.getAgility())
                .append(System.lineSeparator())
                .append("###Intelligence: ").append(hero.getIntelligence());

        return sb.toString();
    }

    private String getHeroItems(Collection<Item> items) {
        StringBuilder sb = new StringBuilder();
        if (items.isEmpty()) {
            sb.append("None");
            return sb.toString();
        }
        for (Item item : items) {
            sb.append(item.getName()).append(", ");
        }


        return sb.toString().substring(0, sb.length() - 2);
    }
}

