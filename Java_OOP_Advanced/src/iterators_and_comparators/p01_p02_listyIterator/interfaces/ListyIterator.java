package iterators_and_comparators.p01_p02_listyIterator.interfaces;

public interface ListyIterator<E> extends Iterable<E> {
    boolean move();
    void print();
    boolean listyHasNext();
}
