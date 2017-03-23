package generics.exercises.p10_tuple.models;

import generics.exercises.p10_tuple.interfaces.Tuple;

public class TupleImpl<T, E> implements Tuple<T, E> {
    private T itemOne;
    private E itemTwo;

    public TupleImpl(T itemOne, E itemTwo) {
        this.setItemOne(itemOne);
        this.setItemTwo(itemTwo);
    }

    private void setItemOne(T itemOne) {
        this.itemOne = itemOne;
    }

    private void setItemTwo(E itemTwo) {
        this.itemTwo = itemTwo;
    }

    @Override
    public T getItemOne() {
        return this.itemOne;
    }

    @Override
    public E getItemTwo() {
        return this.itemTwo;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getItemOne(), this.getItemTwo());
    }
}
