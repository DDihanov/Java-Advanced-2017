package generics.exercises.p07_p08_p09_custom_list.models;

import generics.exercises.p07_p08_p09_custom_list.interfaces.ICustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ICustomListImpl<T extends Comparable<T>> implements ICustomList<T>, Iterable<T> {
    private List<T> elements;

    public ICustomListImpl() {
        this.elements = new ArrayList<T>();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public T remove(int index) {
        return this.elements.remove(index);
    }

    @Override
    public boolean contains(T element) {
        if (this.elements.contains(element)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void swap(int indexFirst, int indexSecond) {
        T first = this.elements.get(indexFirst);
        T second = this.elements.get(indexSecond);

        this.elements.set(indexFirst, second);
        this.elements.set(indexSecond, first);
    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;

        for (T t : this.elements) {
            if(t.compareTo(element)> 0){
                count++;
            }
        }

        return count;
    }

    @Override
    public T getMax() {
        T max = this.elements.get(0);

        for (T element : elements) {
            if(element.compareTo(max) > 0){
                max = element;
            }
        }

        return max;
    }

    @Override
    public T getMin() {
        T min = this.elements.get(0);

        for (T element : elements) {
            if(element.compareTo(min) < 0){
                min = element;
            }
        }

        return min;
    }

    @Override
    public void print() {
        for (T element : this.elements) {
            System.out.println(element);
        }
    }

    @Override
    public int getSize(){
        return this.elements.size();
    }

    @Override
    public T get(int index){
        return this.elements.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }
}
