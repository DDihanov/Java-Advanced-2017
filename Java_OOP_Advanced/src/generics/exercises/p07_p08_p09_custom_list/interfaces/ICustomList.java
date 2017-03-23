package generics.exercises.p07_p08_p09_custom_list.interfaces;

public interface ICustomList<T extends Comparable<T>>{
    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int indexFirst, int indexSecond);

    int countGreaterThan(T element);

    T getMax();

    T getMin();

    void print();

    int getSize();

    T get(int index);
}
