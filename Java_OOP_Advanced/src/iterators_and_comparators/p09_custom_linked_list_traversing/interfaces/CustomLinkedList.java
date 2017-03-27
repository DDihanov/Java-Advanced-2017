package iterators_and_comparators.p09_custom_linked_list_traversing.interfaces;

public interface CustomLinkedList<T> extends Iterable<T> {
    void addLast(T element);
    void addFirst(T element);
    boolean remove(T element);
    int getSize();
}
