package iterators_and_comparators.p04_froggy.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {
    private List<T> data;

    public Lake() {
        this.data = new ArrayList<>();
    }

    public void add(T... elements) {
        this.data.addAll(Arrays.asList(elements));
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {
        private int evenIndex = 0;
        private int oddIndex = 1;
        private boolean hasFinishedEvens;

        @Override
        public boolean hasNext() {
            if (this.evenIndex < data.size()){
                return true;
            }
            this.hasFinishedEvens = true;
            if (this.oddIndex < data.size()){
                return true;
            }

            return false;
        }

        @Override
        public T next() {
            if (!this.hasFinishedEvens) {
                T datum = data.get(evenIndex);
                evenIndex += 2;
                return datum;
            }
            T datum = data.get(oddIndex);
            oddIndex += 2;
            return datum;
        }
    }
}
