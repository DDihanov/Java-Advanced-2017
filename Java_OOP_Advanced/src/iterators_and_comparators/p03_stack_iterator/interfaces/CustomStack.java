package iterators_and_comparators.p03_stack_iterator.interfaces;


public interface CustomStack<T> extends Iterable<T> {
    void push(T... elements);
    T pop();
}
