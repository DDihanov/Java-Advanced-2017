package generics.exercises.p07_p08_p09_custom_list.models;

import generics.exercises.p07_p08_p09_custom_list.interfaces.ICustomList;

public class Sorter {
    public static <T extends Comparable<T>> void sort(ICustomList<T> list){
        for (int i = 0; i < list.getSize(); i++) {
            T el = list.get(i);
            for (int j = i + 1; j < list.getSize(); j++) {
                T elementToSwap = list.get(j);
                if(el.compareTo(elementToSwap) > 0){
                    list.swap(i, j);
                }
            }
        }
    }
}
