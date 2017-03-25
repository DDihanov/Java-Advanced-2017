package iterators_and_comparators.p05_comparing_objects.interfaces;

public interface Person extends Comparable<Person> {

    String getName();

    Integer getAge();

    String getTown();
}
