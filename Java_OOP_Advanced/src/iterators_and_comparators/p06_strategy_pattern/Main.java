package iterators_and_comparators.p06_strategy_pattern;

import iterators_and_comparators.p06_strategy_pattern.comparators.PersonAgeComp;
import iterators_and_comparators.p06_strategy_pattern.comparators.PersonNameComp;
import iterators_and_comparators.p06_strategy_pattern.interfaces.Person;
import iterators_and_comparators.p06_strategy_pattern.models.PersonImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> sortedByName = new TreeSet<>(new PersonNameComp());
        Set<Person> sortedByAge = new TreeSet<>(new PersonAgeComp());

        int count = Integer.parseInt(sc.readLine());

        for (int i = 0; i < count; i++) {
            String[] info = sc.readLine().split("\\s+");
            Person person = new PersonImpl(Integer.parseInt(info[1]), info[0]);

            sortedByAge.add(person);
            sortedByName.add(person);
        }

        for (Person person : sortedByName) {
            System.out.println(person);
        }
        for (Person person : sortedByAge) {
            System.out.println(person);
        }

    }
}
