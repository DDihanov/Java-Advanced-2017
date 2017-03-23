package generics.exercises.p11_threeuple.models;

import generics.exercises.p11_threeuple.interfaces.Tuple;

public class TupleImpl<T, E, P> implements Tuple<T, E, P> {
    private T itemOne;
    private E itemTwo;
    private P itemThree;

    public TupleImpl(T itemOne, E itemTwo, P itemThree) {
        this.setItemOne(itemOne);
        this.setItemTwo(itemTwo);
        this.setItemThree(itemThree);
    }

    private void setItemOne(T itemOne) {
        this.itemOne = itemOne;
    }

    private void setItemTwo(E itemTwo) {
        this.itemTwo = itemTwo;
    }

    private void setItemThree(P itemThree) {
        this.itemThree = itemThree;
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
    public P getItemThree() {
        return this.itemThree;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.getItemOne(), this.getItemTwo(), this.getItemThree());
    }
}
