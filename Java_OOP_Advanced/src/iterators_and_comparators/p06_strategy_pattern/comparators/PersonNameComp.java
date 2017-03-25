package iterators_and_comparators.p06_strategy_pattern.comparators;

import iterators_and_comparators.p06_strategy_pattern.interfaces.Person;

import java.util.Comparator;

public class PersonNameComp implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        if(name1.length() != name2.length()){
            return Integer.compare(name1.length(), name2.length());
        }

        return Character.compare(Character.toLowerCase(name1.charAt(0)), Character.toLowerCase(name2.charAt(0)));
    }
}
