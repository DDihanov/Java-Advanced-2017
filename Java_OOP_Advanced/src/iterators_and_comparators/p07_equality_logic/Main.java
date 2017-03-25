package iterators_and_comparators.p07_equality_logic;

import iterators_and_comparators.p07_equality_logic.interfaces.Person;
import iterators_and_comparators.p07_equality_logic.models.PersonImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        int count = Integer.parseInt(sc.readLine());

        for (int i = 0; i < count; i++) {
            String[] info = sc.readLine().split("\\s+");
            Person person = new PersonImpl(Integer.parseInt(info[1]), info[0]);

            treeSet.add(person);
            hashSet.add(person);
        }
        
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
