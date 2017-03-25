package iterators_and_comparators.p03_stack_iterator.models;

import iterators_and_comparators.p03_stack_iterator.interfaces.CustomStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomStackImpl<T> implements CustomStack<T>, Iterable<T> {
    private List<T> data;

    public CustomStackImpl() {
        this.data = new ArrayList<T>();
    }

    @Override
    public void push(T[] elements) {
        this.data.addAll(Arrays.asList(elements));
    }

    @Override
    public T pop() {
        if(this.data.isEmpty()){
            throw new IllegalArgumentException("No elements");
        }

        return this.data.remove(this.data.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomStackIterator();
    }

    private final class CustomStackIterator implements Iterator<T>{
        private int index;

        public CustomStackIterator() {
            this.index = data.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.index >= 0 && data.get(this.index) != null;
        }

        @Override
        public T next() {
            return data.get(index--);
        }
    }
}
