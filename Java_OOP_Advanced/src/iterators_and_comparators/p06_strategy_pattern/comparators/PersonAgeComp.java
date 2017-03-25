package iterators_and_comparators.p06_strategy_pattern.comparators;

import iterators_and_comparators.p06_strategy_pattern.interfaces.Person;

import java.util.Comparator;

public class PersonAgeComp implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
