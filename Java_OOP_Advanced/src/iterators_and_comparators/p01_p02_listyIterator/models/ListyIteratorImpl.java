package iterators_and_comparators.p01_p02_listyIterator.models;

import iterators_and_comparators.p01_p02_listyIterator.interfaces.ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIteratorImpl<E> implements ListyIterator<E>, Iterable<E> {
    private List<E> data;
    private int index;

    public ListyIteratorImpl(E... el) {
        this.data = Arrays.asList(el);
        this.index = 0;
    }

    private int getIndex() {
        return index;
    }

    @Override
    public boolean move() {
        if (this.listyHasNext()) {
            this.index++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void print() {
        if(this.data.isEmpty()){
            throw new IllegalArgumentException("Invalid Operation!");
        }

        System.out.println(this.data.get(this.getIndex()));
    }

    @Override
    public boolean listyHasNext() {
        if (this.getIndex() + 1 < this.getSize()) {
            return true;
        } else {
            return false;
        }
    }

    private int getSize() {
        return this.data.size();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListyIteratorInner();
    }


    private final class ListyIteratorInner implements Iterator<E>{
        private int index;

        public ListyIteratorInner() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < data.size() && data.get(this.index) != null;
        }

        @Override
        public E next() {
            return data.get(this.index++);
        }
    }
}
